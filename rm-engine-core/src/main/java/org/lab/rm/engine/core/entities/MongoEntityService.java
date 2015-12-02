package org.lab.rm.engine.core.entities;

import java.io.Serializable;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.NotImplementedException;
import org.bson.Document;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoEntityService<E> implements EntityWriter<E>, EntityReader<E> {

	@Inject
	protected Provider<MongoDatabase> mongoProvider;

	@Override
	public E findByPrimaryKey(Serializable primaryKey) {
		return null;
	}

	@Override
	public SearchResults<E> find(String expression, Integer page, Integer count) {
		BasicDBObject query = new BasicDBObject("i", new BasicDBObject("$gt", 50));
		MongoCollection<Document> collection = getCollection();
		FindIterable<Document> items = collection.find(query);
		SearchResults<E> result = new SearchResults<>();
		for (Iterator iterator = items.iterator(); iterator.hasNext();) {
			Object i = iterator.next();
		}
		return result;
	}

	@Override
	public Message<E> persist(E entity) {
		MongoCollection<Document> collection = getCollection();
		String json = new Gson().toJson(entity);
		Document document = Document.parse(json);
		collection.insertOne(document);
		return new Message<E>().withPayload(entity);
	}

	@Override
	public Message<E> merge(E entity) {
		throw new NotImplementedException("Not implemented merge");
	}

	@Override
	public Message<E> remove(Serializable primaryKey) {
		throw new NotImplementedException("Not implemented remove");
	}

	protected MongoCollection<Document> getCollection() {
		MongoDatabase mongoDatabase = mongoProvider.get();
		return mongoDatabase.getCollection(getCollectionName());
	}

	protected abstract String getCollectionName();
}
