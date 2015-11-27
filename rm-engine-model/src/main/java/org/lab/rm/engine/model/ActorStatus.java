package org.lab.rm.engine.model;

public class ActorStatus {

	private Actor character;

	private Integer currentHitPoints;

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
