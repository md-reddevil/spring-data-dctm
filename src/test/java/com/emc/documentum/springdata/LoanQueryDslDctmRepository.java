package com.emc.documentum.springdata;

import java.util.List;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.emc.documentum.springdata.core.Loan;
import com.emc.documentum.springdata.repository.DctmRepositoryWithContent;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
public interface LoanQueryDslDctmRepository extends DctmRepositoryWithContent<Loan, String>, QuerydslPredicateExecutor<Loan> {
  List<Loan> findByAmountGreaterThan(int amount);
}
