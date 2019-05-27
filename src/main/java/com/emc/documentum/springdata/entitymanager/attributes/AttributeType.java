package com.emc.documentum.springdata.entitymanager.attributes;

import com.emc.documentum.springdata.entitymanager.annotations.RelationshipType;

public class AttributeType {

    private final String fieldName;
    private final Attribute<?> attribute;
    private final boolean isRelation;
    private final String relationName;
    private final RelationshipType relationshipType;
    private final Class<?> relatedEntityClass;
    private final boolean isContent;

    public AttributeType(String fieldName, Attribute<?> attribute) {
        this(fieldName, attribute, false, "", null, null, false);
    }

    public AttributeType(
        String fieldName, Attribute<?> attribute, boolean isRelation, String relationName, RelationshipType relationshipType, Class<?> relatedEntityClass, boolean isContent
    ) {
        this.fieldName = fieldName;
        this.attribute = attribute;
        this.isRelation = isRelation;
        this.relationName = relationName;
        this.relationshipType = relationshipType;
        this.relatedEntityClass = relatedEntityClass;
        this.isContent = isContent;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Attribute<?> getAttribute() {
        return this.attribute;
    }

    public boolean isRelation() {
        return isRelation;
    }

    public String getRelationName() {
        return relationName;
    }

    public Class<?> getRelatedEntityClass() {
        return relatedEntityClass;
    }

    public RelationshipType getRelationshipType() {
        return relationshipType;
    }

    @Override
    public String toString() {
        return "AttributeType{" +
            "fieldName='" + fieldName + '\'' +
            ", attribute=" + attribute +
            ", isRelation=" + isRelation +
            ", relationName='" + relationName + '\'' +
            ", relationshipType=" + relationshipType +
            ", relatedEntityClass=" + relatedEntityClass +
            '}';
    }

	public boolean isContent() {
		return isContent;
	}
}
