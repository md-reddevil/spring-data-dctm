package com.emc.documentum.springdata.security;

import com.documentum.fc.client.DfClient;
import com.documentum.fc.client.IDfClient;
import com.documentum.fc.client.IDfDocbaseMap;
import com.documentum.fc.common.DfException;
import com.documentum.fc.common.DfLoginInfo;
import com.documentum.fc.common.IDfLoginInfo;
import com.emc.documentum.springdata.core.Documentum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */

/**
 * Created by Raman Walia
 */
@Component
public class DocumentumAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    Documentum documentum;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {



        try {
            String username = authentication.getName();
            String docBase = getRepositoryName(username);
            String password = authentication.getCredentials().toString();

            authenticate(username,password, docBase);
            documentum.setCredentials(new UserCredentials(username, password));
            documentum.setDocBase(docBase);
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            return new UsernamePasswordAuthenticationToken(username,password, grantedAuths);
        } catch (IOException e) {
            throw new InternalAuthenticationServiceException("Unable to Authenticate", e);
        } catch (DfException e) {
            throw new InternalAuthenticationServiceException("Unable to Authenticate", e);
        }

    }


    @Override
    public boolean supports(Class<?> aClass) {

        return aClass.equals(UsernamePasswordAuthenticationToken.class) ;
    }

    private boolean authenticate(String username, String password, String docBase) throws IOException, DfException {
        IDfLoginInfo loginInfo = new DfLoginInfo(username, password);

        IDfClient client = new DfClient();
        client.authenticate(docBase, loginInfo);
        return true;
    }


    private String getRepositoryName(String userName) throws DfException {
        if (userName.contains("@"))
            return userName.substring(userName.indexOf('@'), userName.length());
        else{
            return getRepositoriesFromDocBroker();

        }
    }

    private String getRepositoriesFromDocBroker() throws DfException {
        IDfClient client = new DfClient();
        IDfDocbaseMap docbases=  client.getDocbaseMap();
        if (docbases.getDocbaseCount() == 1)
                return docbases.getDocbaseName(0);
            else
                throw new AuthenticationCredentialsNotFoundException("Docborker has more than one repository. Either" +
                        " specify the repo name in repository.property or append it with user like username@reponame");

    }
}
