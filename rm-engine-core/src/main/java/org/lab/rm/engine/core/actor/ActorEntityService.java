package org.lab.rm.engine.core.actor;

import javax.inject.Inject;
import javax.inject.Provider;

import org.bson.Document;
import org.lab.rm.engine.model.Actor;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;
import org.lab.rm.engine.model.common.User;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ActorEntityService {

	@Inject
	private Provider<MongoDatabase> mongodbProvider;

	public Message<Actor> persist(Actor actor) {
		MongoDatabase database = mongodbProvider.get();
		MongoCollection<Document> actors = database.getCollection("actors");
		String actorJson = new Gson().toJson(actor);
		actors.insertOne(Document.parse(actorJson));
		return new Message<Actor>().withPayload(actor);
	}

	public Message<Actor> merge(Actor actor) {
		throw new RuntimeException("Not implemented");
	}

	public SearchResults<Actor> find(String name, User owner) {
		throw new RuntimeException("Not implemented");
	}
}
