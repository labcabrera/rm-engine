package org.lab.rm.engine.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.lab.rm.engine.model.actor.ActorContext;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("campaigns")
public class Campaign {

	@Id
	private ObjectId id;

	@Reference
	private User owner;

	private String name;

	@Reference
	private List<ActorContext> actors;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ActorContext> getActors() {
		return actors;
	}

	public void setActors(List<ActorContext> actors) {
		this.actors = actors;
	}
}
