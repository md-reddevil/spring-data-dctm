package com.emc.documentum.springdata.entitymanager.attributes;

import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;

public class StringAttribute extends Attribute<String> {

    public StringAttribute(String name) {
        super(name);
        dfAttributeType = 2;
    }


    @Override
    protected String doGetValue(Object o) throws DfException {
        return ((IDfTypedObject) o).getString(name);
    }
}

