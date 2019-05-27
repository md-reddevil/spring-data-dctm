package com.emc.documentum.springdata.entitymanager.attributes;

import com.documentum.fc.client.IDfSysObject;
import com.documentum.fc.client.IDfTypedObject;
import com.documentum.fc.common.DfException;

import java.util.ArrayList;
import java.util.List;

	
public class IntListAttribute extends IterableAttribute<List<Integer>> {

	    public IntListAttribute(java.lang.String name) {
	        super(name);
	    }

	    @Override
	    protected List<Integer> doGetValue(Object o) throws DfException {
	        List<Integer> values = new ArrayList<Integer>();
	        IDfTypedObject obj = (IDfTypedObject) o;
	        int size = obj.getValueCount(name);

	        for (int i = 0 ; i < size; i++)
	            values.add(obj.getRepeatingInt(name,i));

	        return values;
	    }

		@Override
		public void setValue(IDfSysObject dctmObject, List<Object> valueToSet) throws DfException {
			
			dctmObject.removeAll(name);
			
	         for (int i = 0; i < valueToSet.size(); i++) {
	             dctmObject.setRepeatingInt(name, i, (Integer) valueToSet.get(i));
	         }
		}
}