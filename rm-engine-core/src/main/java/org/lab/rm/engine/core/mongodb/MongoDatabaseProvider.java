package org.lab.rm.engine.core.mongodb;

import javax.inject.Provider;

import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Singleton
public class MongoDatabaseProvider implements Provider<MongoDatabase> {

	private final ThreadLocal<MongoDatabase> threadLocal;

	public MongoDatabaseProvider() {
		threadLocal = new ThreadLocal<>();
	}

	@Override
	@SuppressWarnings("resource")
	public MongoDatabase get() {
		if (threadLocal.get() == null) {
			MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
			MongoDatabase dataBase = mongoClient.getDatabase("rm-engine");
			threadLocal.set(dataBase);
		}
		return threadLocal.get();
	}

}
