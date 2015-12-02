package org.lab.rm.engine.web;

import org.lab.rm.engine.core.guice.RmEngineModule;
import org.lab.rm.engine.web.json.GsonMessageBodyHandler;
import org.lab.rm.engine.web.rest.EntityRestService;
import org.lab.rm.engine.web.rest.RandomRestService;
import org.lab.rm.engine.web.security.SecurityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;

public class RestModule implements Module {

	private static final Logger LOG = LoggerFactory.getLogger(RestModule.class);

	@Override
	public void configure(final Binder binder) {
		LOG.debug("Configuring Guice Module");
		binder.install(new RmEngineModule());
		binder.bind(GsonMessageBodyHandler.class);
		binder.bind(SecurityInterceptor.class);
		bindRestServices(binder);
	}

	private void bindRestServices(Binder binder) {
		binder.bind(EntityRestService.class);
		binder.bind(RandomRestService.class);
	}
}
