package com.emc.documentum.springdata.entitymanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import com.emc.documentum.springdata.entitymanager.mapping.DctmEntity;

@Component
public class EntityTypeHandler {
	
	@Autowired
	Environment env;

    public String getEntityObjectName(Class<?> entityClass) {
        Assert.notNull(entityClass, "No class parameter provided, entity collection can't be determined!");
        return getEntityObjectNameFromClass(entityClass);
    }

    public String getEntityObjectNameFromClass(Class<?> type) {
        DctmEntity dctmObject = AnnotationUtils.findAnnotation(type, DctmEntity.class);
        
        String entityName = StringUtils.isEmpty(dctmObject.repository()) ? type.getSimpleName() : dctmObject.repository();
        if (entityName.matches("\\$\\{.*\\}")) {
			String envProperty = entityName.replace("${", "").replace("}", "");
			entityName = env.getProperty(envProperty);
		}
		return entityName;
    }
}
