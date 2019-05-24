package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.data.mapping.Association;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.model.AnnotationBasedPersistentProperty;
import org.springframework.data.mapping.model.Property;
import org.springframework.data.mapping.model.SimpleTypeHolder;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 *
 * @author Raman Walia
 */

public class BasicDctmPersistentProperty extends AnnotationBasedPersistentProperty<DctmPersistentProperty>
        implements DctmPersistentProperty{

    /**
     * Creates a new {@link AnnotationBasedPersistentProperty}.
     *
     * @param property              must not be {@literal null}.
     * @param owner              must not be {@literal null}.
     * @param simpleTypeHolder description
     */
    public BasicDctmPersistentProperty(Property property, PersistentEntity<?, DctmPersistentProperty> owner, SimpleTypeHolder simpleTypeHolder) {
    	super(property,owner,simpleTypeHolder);
    }
    

    @Override
    protected Association<DctmPersistentProperty> createAssociation() {
        return new Association<DctmPersistentProperty>(this, null);
    }
}
