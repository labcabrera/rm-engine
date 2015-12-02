package org.lab.rm.engine.core.actor;

import org.lab.rm.engine.core.entities.MongoEntityService;
import org.lab.rm.engine.model.Actor;

public class ActorEntityService extends MongoEntityService<Actor> {

	@Override
	protected String getCollectionName() {
		return "actors";
	}
}
