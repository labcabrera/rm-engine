package com.lab.rm.engine.deploy;

import org.lab.rm.engine.core.guice.RmEngineModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Bootstrap {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new RmEngineModule());
		injector.getInstance(UserFeeder.class).run();
		injector.getInstance(ArmorTypeFeeder.class).run();
	}
}
