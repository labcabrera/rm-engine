package org.lab.rm.engine.model.actor;

import org.bson.types.ObjectId;

public class ActorContext {

	private ObjectId _id;

	private Actor character;

	private Integer currentHitPoints;

	public ObjectId getId() {
		return _id;
	}

	public void set_id(ObjectId id) {
		this._id = id;
	}

	public Actor getCharacter() {
		return character;
	}

	public void setCharacter(Actor character) {
		this.character = character;
	}

	public Integer getCurrentHitPoints() {
		return currentHitPoints;
	}

	public void setCurrentHitPoints(Integer currentHitPoints) {
		this.currentHitPoints = currentHitPoints;
	}
}
