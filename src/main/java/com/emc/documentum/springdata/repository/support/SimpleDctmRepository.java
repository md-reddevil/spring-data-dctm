package com.emc.documentum.springdata.repository.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;

import com.documentum.fc.common.DfException;
import com.emc.documentum.springdata.core.DctmOperations;
import com.emc.documentum.springdata.repository.DctmRepository;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
public class SimpleDctmRepository<T, ID extends Serializable> implements DctmRepository<T, ID> {

  private Logger logger = Logger.getLogger(SimpleDctmRepository.class);
  protected DctmEntityInformation<T, ID> dctmEntityInformation;
  protected DctmOperations dctmTemplate;

  public SimpleDctmRepository(DctmEntityInformation<T, ID> dctmEntityInformation, ApplicationContext applicationContext) {
    dctmTemplate = applicationContext.getBean(DctmOperations.class);
    this.dctmEntityInformation = dctmEntityInformation;
  }

  @Override
  public <S extends T> S save(S entity) {
    S createdEntity = null;
    try {
      createdEntity = dctmTemplate.create(entity);
    } catch (DfException e) {
      e.printStackTrace();
    }
    return createdEntity;
  }

  @Override
  public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
    List<S> retVal = new ArrayList<>();
    for (S entity : entities) {
      retVal.add(save(entity));
    }
    return retVal;
  }

  @Override
  public Optional<T> findById(ID id) {
    T retVal = null;
    try {
      retVal = dctmTemplate.findById(id.toString(), dctmEntityInformation.getJavaType());
    } catch (DfException e) {
      e.printStackTrace();
    }
    return Optional.of(retVal);
  }

  @Override
  public boolean existsById(ID id) {
    return findById(id) != null;
  }

  @Override
  public Iterable<T> findAll() {
    List<T> retVal = null;
    try {
      retVal = dctmTemplate.findAll(dctmEntityInformation.getJavaType());
    } catch (DfException e) {
      e.printStackTrace();
    }
    return retVal;
  }

  @Override
  public Iterable<T> findAllById(Iterable<ID> ids) {
    List<T> foundObjects = new ArrayList<>();
    for (ID id : ids) {
      Optional<T> found = findById(id);
      if(found.isPresent())
        foundObjects.add(found.get());
    }
    return foundObjects;
  }

  @Override
  public long count() {
	try {
	  return dctmTemplate.count(dctmEntityInformation.getJavaType());
	  } catch (DfException e) {
	    e.printStackTrace();
	    return 0;
	  }
  }

  @Override
  public void deleteById(ID id) {
    try {
      dctmTemplate.deleteById(id.toString());
    } catch (DfException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void delete(T entity) {
    try {
      dctmTemplate.delete(entity);
    } catch (DfException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void deleteAll(Iterable<? extends T> entities) {
    for (T entity : entities) {
      try {
        dctmTemplate.delete(entity);
      } catch (DfException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public void deleteAll() {
    throw new UnsupportedOperationException();//TODO Coming Soon....
  }
}
