package org.lab.rm.engine.model.user;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("users")
public class User {

	@Id
	private ObjectId _id;

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

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
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
