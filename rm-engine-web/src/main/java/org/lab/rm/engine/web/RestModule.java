package org.lab.rm.engine.web;

import org.lab.rm.engine.core.guice.RmEngineModule;
import org.lab.rm.engine.web.json.GsonMessageBodyHandler;
import org.lab.rm.engine.web.rest.RandomRestService;
import org.lab.rm.engine.web.security.SecurityInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * Modulo de Guice encargado de registrar los servicios REST que expone la aplicacion.
 */
public class RestModule implements Module {

	private static final Logger LOG = LoggerFactory.getLogger(RestModule.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.google.inject.Module#configure(com.google.inject.Binder)
	 */
	@Override
	public void configure(final Binder binder) {
		LOG.debug("Configuring Guice Module");
		binder.install(new RmEngineModule());
		// Components
		binder.bind(GsonMessageBodyHandler.class);
		// Security
		binder.bind(SecurityInterceptor.class);
		// Rest services
		binder.bind(RandomRestService.class);
	}
}
