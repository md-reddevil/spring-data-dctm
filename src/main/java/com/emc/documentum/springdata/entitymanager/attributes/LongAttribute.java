package com.emc.documentum.springdata.entitymanager.attributes;

import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;

public class LongAttribute extends Attribute<Long> {

    public LongAttribute(String name) {
        super(name);
        dfAttributeType = 5;
    }

    @Override
    protected Long doGetValue(Object o) throws DfException {
        return ((IDfTypedObject) o).getLong(name);

    }
}