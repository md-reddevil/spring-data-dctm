package com.emc.documentum.springdata.entitymanager.attributes;

import com.documentum.fc.common.DfException;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
public class EntityAttribute<T> extends Attribute<T> {

  public EntityAttribute(String name) {
    super(name);
  }

  @Override
  protected T doGetValue(Object o) throws DfException {
    return null;
  }
}
