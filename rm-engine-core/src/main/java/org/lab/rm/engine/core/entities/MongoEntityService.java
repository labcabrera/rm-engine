package org.lab.rm.engine.core.entities;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Provider;

import org.bson.Document;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;
import org.lab.rm.engine.model.common.User;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoEntityService<E> implements EntityWriter<User>, EntityReader<User> {

	@Inject
	protected Provider<MongoDatabase> mongoProvider;

	@Override
	public User findByPrimaryKey(Serializable primaryKey) {
		return null;
	}

	@Override
	public SearchResults<User> find(String expression, Integer page, Integer count) {
		BasicDBObject query = new BasicDBObject("i", new BasicDBObject("$gt", 50));
		MongoCollection<Document> collection = getCollection();
		FindIterable<Document> items = collection.find(query);
		SearchResults<User> result = new SearchResults<>();
		for (Iterator iterator = items.iterator(); iterator.hasNext();) {
			Object i = iterator.next();

		}
		return result;
	}

	@Override
	public Message<User> persist(User entity) {
		MongoCollection<Document> collection = getCollection();
		String json = new Gson().toJson(entity);
		Document document = Document.parse(json);
		collection.insertOne(document);
		return new Message<User>().withPayload(entity);
	}

	@Override
	public Message<User> merge(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message<User> remove(User e) {
		// TODO Auto-generated method stub
		return null;
	}

	protected MongoCollection<Document> getCollection() {
		MongoDatabase mongoDatabase = mongoProvider.get();
		return mongoDatabase.getCollection(getCollectionName());
	}

	protected abstract String getCollectionName();
}
