package com.emc.documentum.springdata.repository.support;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
@NoRepositoryBean
public class QueryDslDctmRepositoryWithContent<T, ID extends Serializable> extends SimpleDctmRepositoryWithContent<T, ID>
    implements QuerydslPredicateExecutor<T> {

  public QueryDslDctmRepositoryWithContent(DctmEntityInformation<T, ID> dctmEntity, ApplicationContext applicationContext) {
    super(dctmEntity, applicationContext);
  }

  @Override
  public Optional<T> findOne(Predicate predicate) {
    return null;
  }

  @Override
  public Iterable<T> findAll(Predicate predicate) {
    return null;
  }

  @Override
  public Iterable<T> findAll(Predicate predicate, OrderSpecifier<?>... orders) {
    return null;
  }

  @Override
  public Page<T> findAll(Predicate predicate, Pageable pageable) {
    return null;
  }

  @Override
  public long count(Predicate predicate) {
    return 0;
  }

@Override
public Iterable<T> findAll(Predicate predicate, Sort sort) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Iterable<T> findAll(OrderSpecifier<?>... orders) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public boolean exists(Predicate predicate) {
	// TODO Auto-generated method stub
	return false;
}
}
