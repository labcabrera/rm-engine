package org.lab.rm.engine.core.security;

import org.lab.rm.engine.model.user.User;

import com.google.inject.Singleton;

@Singleton
public class SecurityService {

	private final ThreadLocal<User> users;

	public SecurityService() {
		users = new ThreadLocal<>();
	}

	public void setCurrentUser(User user) {
		users.set(user);
	}

	public User getCurrentUser() {
		return users.get();
	}
}
