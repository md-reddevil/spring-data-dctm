package com.emc.documentum.springdata.entitymanager.mapping;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Copyright (c) 2015 EMC Corporation. All Rights Reserved.
 * EMC Confidential: Restricted Internal Distribution
 */

/**
 *  * Annotation to define custom metadata for DCTMObject fields.
 *
 * @author Raman Walia
 *  
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DctmAttribute {

    /**
     * The key to be used to store the field inside the document.
     *
     * @return String
     */

    String value() default "";
}


