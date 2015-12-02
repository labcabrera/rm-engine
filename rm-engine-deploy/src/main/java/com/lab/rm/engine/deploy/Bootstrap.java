package com.lab.rm.engine.deploy;

import org.lab.rm.engine.core.guice.CoreModule;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lab.rm.engine.deploy.feeders.ArmorFeeder;
import com.lab.rm.engine.deploy.feeders.UserFeeder;
import com.lab.rm.engine.deploy.feeders.WeaponFeeder;

public class Bootstrap {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CoreModule());
		injector.getInstance(UserFeeder.class).run();
		injector.getInstance(WeaponFeeder.class).run();
		injector.getInstance(ArmorFeeder.class).run();
	}
}
