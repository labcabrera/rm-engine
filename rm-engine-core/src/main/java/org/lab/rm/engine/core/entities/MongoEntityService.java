package org.lab.rm.engine.core.entities;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Provider;

import org.apache.commons.lang3.NotImplementedException;
import org.bson.Document;
import org.lab.rm.engine.core.guice.serialization.Serializer;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public abstract class MongoEntityService<E> implements EntityWriter<E>, EntityReader<E> {

	@Inject
	protected Provider<MongoDatabase> mongoProvider;
	@Inject
	protected Serializer serializer;

	@Override
	public E findByPrimaryKey(Serializable primaryKey) {
		return null;
	}

	@Override
	public SearchResults<E> find(String expression, Integer page, Integer count) {
		throw new NotImplementedException("find");
		// MongoCollection<Document> collection = getCollection();
		// FindIterable<Actor> items;
		// if (StringUtils.isNotEmpty(expression)) {
		// BsonDocument filter = BsonDocument.parse(expression);
		// items = collection.find(filter, Actor.class);
		// } else {
		// items = collection.find(Actor.class);
		// }
		//
		// final SearchResults<Actor> result = new SearchResults<>();
		// result.setResults(new ArrayList<E>());
		// items.forEach(new Block<Actor>() {
		//
		// @Override
		// public void apply(Actor t) {
		// result.getResults().add(t);
		//
		// }
		// });
		// return result;
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
