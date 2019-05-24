package com.emc.documentum.springdata.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */

@NoRepositoryBean
public interface DctmRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

  <S extends T> S save(S entity);


}
