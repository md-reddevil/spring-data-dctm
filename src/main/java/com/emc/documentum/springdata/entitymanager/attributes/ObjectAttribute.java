package com.emc.documentum.springdata.entitymanager.attributes;

import com.documentum.fc.common.DfException;

public class ObjectAttribute extends Attribute<Object> {

    public ObjectAttribute(String name) {
        super(name);
    }

    @Override
    protected Object doGetValue(Object o) throws DfException {
        return null;
    }
}
