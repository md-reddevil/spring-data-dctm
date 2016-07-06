package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.data.mapping.model.BasicPersistentEntity;
import org.springframework.data.util.TypeInformation;

import java.util.Comparator;

/**
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */


/**
 *
 * @param <T>
 *
 * @author Raman Walia
 */
public class BasicDctmPersistentEntity<T> extends BasicPersistentEntity<T, DctmPersistentProperty>

    {
    public BasicDctmPersistentEntity(TypeInformation<T> information) {
        super(information);
    }

    public BasicDctmPersistentEntity(TypeInformation<T> information, Comparator<DctmPersistentProperty> comparator) {
        super(information, comparator);
    }


    }
