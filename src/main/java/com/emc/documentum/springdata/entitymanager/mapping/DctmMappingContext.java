package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.data.mapping.context.AbstractMappingContext;
import org.springframework.data.mapping.model.SimpleTypeHolder;
import org.springframework.data.util.TypeInformation;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

/**
 * Created by waliar on 7/5/16.
 */
public class DctmMappingContext extends AbstractMappingContext<BasicDctmPersistentEntity<?>, DctmPersistentProperty> {
    @Override
    protected <T> BasicDctmPersistentEntity<?> createPersistentEntity(TypeInformation<T> typeInformation) {
        return new BasicDctmPersistentEntity<T>(typeInformation);
    }

    @Override
    protected DctmPersistentProperty createPersistentProperty(Field field, PropertyDescriptor descriptor,
                                                              BasicDctmPersistentEntity<?> owner,
                                                              SimpleTypeHolder simpleTypeHolder) {
        return new BasicDctmPersistentProperty(field,descriptor, owner, simpleTypeHolder);
    }
}
