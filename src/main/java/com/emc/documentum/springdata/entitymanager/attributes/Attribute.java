package com.emc.documentum.springdata.entitymanager.attributes;

import org.springframework.stereotype.Component;

import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;

@Component
public abstract class Attribute<T> {

	protected int dfAttributeType;
	public String name;

	public int getDfAttributeType() {
		return dfAttributeType;
	}

	public Attribute(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public T getValue(Object o) throws DfException {
		if(((IDfTypedObject)o).hasAttr(name))
			return doGetValue(o);
		return null;
	}
	
	protected abstract T doGetValue(Object o) throws DfException;
	
}
