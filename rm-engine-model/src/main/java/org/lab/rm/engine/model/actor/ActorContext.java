package org.lab.rm.engine.model.actor;

import org.bson.types.ObjectId;

import com.mongodb.DBRef;

public class ActorContext {

	private ObjectId _id;

	private DBRef character;

	private Integer currentHitPoints;

	public ObjectId getId() {
		return _id;
	}

	public DBRef getCharacter() {
		return character;
	}

	public void setCharacter(DBRef character) {
		this.character = character;
	}

	public Integer getCurrentHitPoints() {
		return currentHitPoints;
	}

	public void setCurrentHitPoints(Integer currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}
}
