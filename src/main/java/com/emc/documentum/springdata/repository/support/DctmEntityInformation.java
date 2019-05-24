package com.emc.documentum.springdata.repository.support;

import org.springframework.data.repository.core.EntityInformation;

import com.emc.documentum.springdata.repository.query.DctmEntityMetadata;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
public interface DctmEntityInformation<T, ID> extends EntityInformation<T, ID>, DctmEntityMetadata<T> {
}
