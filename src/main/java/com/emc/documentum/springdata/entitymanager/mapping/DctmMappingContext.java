package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.data.mapping.context.AbstractMappingContext;
import org.springframework.data.mapping.model.Property;
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
	protected DctmPersistentProperty createPersistentProperty(Property property, BasicDctmPersistentEntity<?> owner,
			SimpleTypeHolder simpleTypeHolder) {
		// TODO Auto-generated method stub
		return new BasicDctmPersistentProperty(property, owner, simpleTypeHolder);
	}
}
