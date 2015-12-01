package org.lab.rm.engine.test;

import java.util.Iterator;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.junit.Test;
import org.lab.rm.engine.core.mongodb.codecs.UserCodec;
import org.lab.rm.engine.model.common.User;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;

public class TestCodec {

	@Test
	public void test() {
		Codec<Document> defaultDocumentCodec = MongoClient.getDefaultCodecRegistry().get(Document.class);
		UserCodec gradeCodec = new UserCodec(defaultDocumentCodec);
		CodecRegistry codecRegistry = CodecRegistries.fromRegistries(MongoClient.getDefaultCodecRegistry(), CodecRegistries.fromCodecs(gradeCodec));
		MongoClientOptions options = MongoClientOptions.builder().codecRegistry(codecRegistry).build();
		MongoClient mc = new MongoClient("localhost:27017", options);
		MongoCollection<User> collection = mc.getDatabase("rm-engine").getCollection("user", User.class);

		collection.insertOne(new User("lab.cabrera", "lab.cabrera@gmail.com"));
		collection.insertOne(new User("jdoe", "john.doe@gmail.com"));

		User first = collection.find(User.class).first();
		System.out.println("First: " + first);

		System.out.println("All results");
		MongoCursor<User> iterator = collection.find(User.class).iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user.getName() + ", " + user.getEmail());
		}

		System.out.println("Filtered results results");
		Bson filter = BsonDocument.parse("{\"name\": \"jdoe\"}");
		iterator = collection.find(filter, User.class).iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			System.out.println(user.getName() + ", " + user.getEmail());
		}

		mc.close();
	}

}
