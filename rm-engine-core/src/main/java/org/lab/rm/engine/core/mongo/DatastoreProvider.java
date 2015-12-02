package org.lab.rm.engine.core.mongo;

import javax.inject.Inject;
import javax.inject.Provider;

import org.lab.rm.engine.core.common.SettingsManager;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.google.inject.Singleton;
import com.mongodb.MongoClient;

@Singleton
public class DatastoreProvider implements Provider<Datastore> {

	@Inject
	private SettingsManager settingsManager;

	private final ThreadLocal<Datastore> threadLocal;
	private final Morphia morphia;

	public DatastoreProvider() {
		morphia = new Morphia();
		morphia.mapPackage("org.lab.rm.engine.model");
		threadLocal = new ThreadLocal<>();
	}

	@Override
	public Datastore get() {
		if (threadLocal.get() == null) {
			String connection = settingsManager.getProperty("mongodb", "connection");
			String databaseName = settingsManager.getProperty("mongodb", "database");
			MongoClient mongoClient = new MongoClient(connection);
			Datastore datastore = morphia.createDatastore(mongoClient, databaseName);
			datastore.ensureIndexes();
			threadLocal.set(datastore);
		}
		return threadLocal.get();
	}

}
