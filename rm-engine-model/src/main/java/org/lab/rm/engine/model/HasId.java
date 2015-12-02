package org.lab.rm.engine.model;

import org.bson.types.ObjectId;

public interface HasId {

	ObjectId getId();

	void setId(ObjectId id);
}
