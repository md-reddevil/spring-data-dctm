package com.emc.documentum.springdata.repository.support;

import com.emc.documentum.springdata.entitymanager.mapping.DctmMappingContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
//TODO: Do we start supporting transactions already?

public class DctmRepositoryFactoryBean extends RepositoryFactoryBeanSupport implements ApplicationContextAware {

  ApplicationContext applicationContext;
  @Autowired
  DctmMappingContext mappingContext;

  @Override
  public void setApplicationContext(ApplicationContext appContext) throws BeansException {
    this.applicationContext = appContext;
  }

  @Override
  protected RepositoryFactorySupport createRepositoryFactory() {
    setMappingContext(mappingContext);
    return new DctmRepositoryFactory(applicationContext);
  }
}
