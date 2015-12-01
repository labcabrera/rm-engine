package org.lab.rm.engine.core.guice;

import org.lab.rm.engine.core.mongodb.MongoDatabaseProvider;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.mongodb.client.MongoDatabase;

public class RmEngineModule implements Module {

	@Override
	public void configure(Binder binder) {
		binder.bind(MongoDatabase.class).toProvider(MongoDatabaseProvider.class);
	}

}
