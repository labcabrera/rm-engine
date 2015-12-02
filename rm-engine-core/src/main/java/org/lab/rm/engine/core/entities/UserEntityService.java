package org.lab.rm.engine.core.entities;

import org.bson.BsonDocument;
import org.bson.conversions.Bson;
import org.lab.rm.engine.model.common.User;

public class UserEntityService extends MongoEntityService<User> {

	@Override
	protected String getCollectionName() {
		return "users";
	}

	public User findByName(String name) {
		Bson filter = BsonDocument.parse(String.format("{\"name\": \"%s\"}", name));
		return getCollection().find(filter, User.class).first();
	}

}