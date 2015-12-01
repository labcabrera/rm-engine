package com.lab.rm.engine.deploy;

import javax.inject.Inject;

import org.lab.rm.engine.core.entities.UserEntityService;
import org.lab.rm.engine.model.common.User;

public class UserFeeder implements Runnable {

	@Inject
	private UserEntityService userEntityService;

	public void run() {
		userEntityService.persist(new User("admin", "lab.cabrera@rmengine.com"));
		userEntityService.persist(new User("lab.cabrera", "lab.cabrera@gmail.com"));
	}
}
