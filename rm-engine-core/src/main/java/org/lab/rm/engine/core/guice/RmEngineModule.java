package org.lab.rm.engine.core.guice;

import org.lab.rm.engine.core.actor.Constants;
import org.lab.rm.engine.core.common.SettingsManager;
import org.lab.rm.engine.core.mongodb.MongoDatabaseProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.mongodb.client.MongoDatabase;

public class RmEngineModule extends AbstractModule {

	private static final Logger LOG = LoggerFactory.getLogger(RmEngineModule.class);

	@Override
	public void configure() {
		LOG.debug("Configuring module");
		SettingsManager settingsManager = new SettingsManager().load(Constants.CONFIG_PATH);
		bind(SettingsManager.class).toInstance(settingsManager);
		Names.bindProperties(binder(), settingsManager.getProperties(Constants.CONFIG_SECTION_GLOBAL));
		bind(MongoDatabase.class).toProvider(MongoDatabaseProvider.class);
	}

}
