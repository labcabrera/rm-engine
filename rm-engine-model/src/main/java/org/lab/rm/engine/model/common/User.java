package org.lab.rm.engine.model.common;

import org.bson.types.ObjectId;
import org.lab.rm.engine.model.HasId;

public class User implements HasId {

	private ObjectId id;

	private String name;

	private String email;

	private String passwordDigest;

	public User() {
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public User withNewObjectId() {
		setId(new ObjectId());
		return this;
	}

	@Override
	public ObjectId getId() {
		return id;
	}

	@Override
	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordDigest() {
		return passwordDigest;
	}

	public void setPasswordDigest(String passwordDigest) {
		this.passwordDigest = passwordDigest;
	}

}
