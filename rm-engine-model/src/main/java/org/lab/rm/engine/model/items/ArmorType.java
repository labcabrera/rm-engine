package org.lab.rm.engine.model.items;

import org.bson.types.ObjectId;

public class ArmorType {

	public static final String COLLECTION_NAME = "armor";

	private ObjectId _id;

	private String code;

	private String description;

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
