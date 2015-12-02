package org.lab.rm.engine.core.mongodb;

import javax.inject.Provider;

import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.lab.rm.engine.core.mongodb.codecs.ActorCodec;
import org.lab.rm.engine.core.mongodb.codecs.UserCodec;

import com.google.inject.Singleton;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoDatabase;

@Singleton
public class MongoDatabaseProvider implements Provider<MongoDatabase> {

	private final ThreadLocal<MongoDatabase> threadLocal;
	private final MongoClient mongoClient;

	// TODO parametrizar cadena de conexion a mongodb
	public MongoDatabaseProvider() {
		threadLocal = new ThreadLocal<>();
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		UserCodec userCodec = new UserCodec(defaultDocumentCodec);
		ActorCodec actorCodec = new ActorCodec(defaultDocumentCodec);
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromCodecs(userCodec, actorCodec));
		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
		mongoClient = new MongoClient("localhost:27017", options);
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
