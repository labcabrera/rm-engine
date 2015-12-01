package org.lab.rm.engine.core.mongodb;

import javax.inject.Provider;

import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@Singleton
public class MongoDatabaseProvider implements Provider<MongoDatabase> {

	private final ThreadLocal<MongoDatabase> threadLocal;
	private final MongoClient mongoClient;

	public MongoDatabaseProvider() {
		threadLocal = new ThreadLocal<>();
		mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
	}

	@Override
	public MongoDatabase get() {
		if (threadLocal.get() == null) {
			MongoDatabase dataBase = mongoClient.getDatabase("rm-engine");
			threadLocal.set(dataBase);
		}
		return threadLocal.get();
	}

}
