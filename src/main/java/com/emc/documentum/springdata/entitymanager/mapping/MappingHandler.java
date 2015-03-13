package com.emc.documentum.springdata.entitymanager.mapping;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.documentum.fc.common.DfException;
import com.emc.documentum.springdata.core.GenericCache;
import com.emc.documentum.springdata.entitymanager.attributes.Attribute;
import com.emc.documentum.springdata.entitymanager.attributes.AttributeFactory;
import com.emc.documentum.springdata.entitymanager.attributes.AttributeType;

@Component
public class MappingHandler {
    
	private final GenericCache cache;

	public MappingHandler() {
        cache = new GenericCache();
    }

	public <T> String getIdField(T objectOfEntityClass) {
		return getIdField(objectOfEntityClass.getClass());
	}
	
	public String getIdField(Class<?> entityClass) {
        Assert.notNull(entityClass, "No class parameter provided, entity collection can't be determined!");
		if(cache.getEntry(entityClass) != null)
		{
			return getIDFromCache(entityClass);
		}
		return null;
	}
	

    private String getIDFromCache(Class<?> entityClass) {
    	Assert.notNull(entityClass, "No class parameter provided, entity collection can't be determined!");
    	ArrayList<AttributeType> mapping =  (ArrayList<AttributeType>) cache.getEntry(entityClass);
    	
    	for(AttributeType attributeType : mapping ){
    		if(attributeType.getAttribute().getName() == "r_object_id"){
    			return attributeType.getFieldName();
    		}
    	}
		return null;
	}
    
	public <T> ArrayList<AttributeType> getAttributeMappings(T objectOfEntityClass) throws DfException {
            return getAttributeMappings(objectOfEntityClass.getClass());
  
    }

	public ArrayList<AttributeType> getAttributeMappings(Class<?> entityClass) throws DfException {
		Assert.notNull(entityClass, "No class parameter provided, entity collection can't be determined!");

        if (cache.getEntry(entityClass) == null) {

            return setAttributeMappingInCache(entityClass);
        } else {

            return (ArrayList<AttributeType>) cache.getEntry(entityClass);
        }
    }

    public ArrayList<AttributeType> setAttributeMappingInCache(Class<?> entityClass) throws DfException {

        Attribute<?> attribute;
        String attributeName;

        ArrayList<AttributeType> mapping = new ArrayList<AttributeType>();
        Field[] fields = entityClass.getDeclaredFields();
        if (fields.length == 0) {
            throw new DfException("No fields to map for the given class!");
        }

        for (Field f : fields) {
            f.setAccessible(true);
            Class<?> type = f.getType();
            attributeName = getEntityFieldName(f);
            attribute = AttributeFactory.getAttribute(type, attributeName);
            AttributeType attributeType = new AttributeType(f.getName(), attribute);
            mapping.add(attributeType);
        }
        cache.setEntry(entityClass, mapping);
        return mapping;
    }

    private String getEntityFieldName(Field f) {
        EntityField entityField;
        String attributeName;

        if (f.isAnnotationPresent(Id.class)) {
            attributeName = "r_object_id";
        } else if (f.isAnnotationPresent(EntityField.class)) {
            entityField = f.getAnnotation(EntityField.class);
            if (entityField != null) {
                attributeName = entityField.value();
            } else {
                attributeName = f.getName();
            }
        } else {
            attributeName = f.getName();
        }
        return attributeName;
    }

}
