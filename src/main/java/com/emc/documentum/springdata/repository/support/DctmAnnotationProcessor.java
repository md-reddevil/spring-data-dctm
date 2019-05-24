package com.emc.documentum.springdata.repository.support;

import java.util.Collections;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.tools.Diagnostic;

import com.emc.documentum.springdata.entitymanager.mapping.DctmEntity;
import com.querydsl.apt.AbstractQuerydslProcessor;
import com.querydsl.apt.Configuration;
import com.querydsl.apt.DefaultConfiguration;
import com.querydsl.core.annotations.QueryEmbeddable;
import com.querydsl.core.annotations.QueryEmbedded;
import com.querydsl.core.annotations.QueryEntities;
import com.querydsl.core.annotations.QuerySupertype;
import com.querydsl.core.annotations.QueryTransient;

/*
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */
@SupportedAnnotationTypes({"com.emc.documentum.springdata.entitymanager.mapping.*", "com.querydsl.annotations.*"})
@SupportedSourceVersion(SourceVersion.RELEASE_7)
public class DctmAnnotationProcessor extends AbstractQuerydslProcessor {
  @Override
  protected Configuration createConfiguration(RoundEnvironment roundEnvironment) {
    processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Running " + getClass().getSimpleName());
    DefaultConfiguration configuration = new DefaultConfiguration(roundEnvironment, processingEnv.getOptions(), Collections.<String> emptySet(),
                                                                  QueryEntities.class, DctmEntity.class, QuerySupertype.class,
                                                                  QueryEmbeddable.class, QueryEmbedded.class, QueryTransient.class);
    configuration.setUnknownAsEmbedded(true);
    return configuration;
  }
  
  
}
