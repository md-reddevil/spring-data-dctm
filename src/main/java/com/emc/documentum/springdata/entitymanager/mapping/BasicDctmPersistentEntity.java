package com.emc.documentum.springdata.entitymanager.mapping;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.expression.BeanFactoryAccessor;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.data.mapping.model.BasicPersistentEntity;
import org.springframework.data.util.TypeInformation;

import java.util.Comparator;

/**
 * Created by waliar on 7/5/16.
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
