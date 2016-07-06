package com.emc.documentum.springdata.core;

import com.emc.documentum.springdata.entitymanager.mapping.DctmMappingContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.mapping.model.FieldNamingStrategy;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 *
 * @author Raman Walia
 */


@Configuration
public class DctmAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public DctmMappingContext mongoMappingContext(BeanFactory beanFactory)
            throws ClassNotFoundException {
        DctmMappingContext context = new DctmMappingContext();
        return context;
    }
}
