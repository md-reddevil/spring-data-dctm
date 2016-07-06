package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.data.mapping.Association;
import org.springframework.data.mapping.PersistentEntity;
import org.springframework.data.mapping.model.AnnotationBasedPersistentProperty;
import org.springframework.data.mapping.model.SimpleTypeHolder;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * Created by waliar on 7/5/16.
 */
public class BasicDctmPersistentProperty extends AnnotationBasedPersistentProperty<DctmPersistentProperty>
        implements DctmPersistentProperty{

    /**
     * Creates a new {@link AnnotationBasedPersistentProperty}.
     *
     * @param field              must not be {@literal null}.
     * @param propertyDescriptor can be {@literal null}.
     * @param owner              must not be {@literal null}.
     * @param simpleTypeHolder
     */
    public BasicDctmPersistentProperty(Field field, PropertyDescriptor propertyDescriptor, PersistentEntity<?, DctmPersistentProperty> owner, SimpleTypeHolder simpleTypeHolder) {
        super(field, propertyDescriptor, owner, simpleTypeHolder);
    }

    @Override
    protected Association<DctmPersistentProperty> createAssociation() {
        return new Association<DctmPersistentProperty>(this, null);
    }
}
