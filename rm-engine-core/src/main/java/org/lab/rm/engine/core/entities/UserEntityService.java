package org.lab.rm.engine.core.entities;

import org.lab.rm.engine.model.common.User;

public class UserEntityService extends MongoEntityService<User> {

	@Override
	protected String getCollectionName() {
		return "user";
	}

}