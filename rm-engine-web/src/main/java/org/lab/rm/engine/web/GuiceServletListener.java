package org.lab.rm.engine.web;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Injector;

public class GuiceServletListener extends GuiceResteasyBootstrapServletContextListener {

	@Override
	protected void withInjector(Injector injector) {
		super.withInjector(injector);
	}
}
