package org.lab.rm.engine.core.actor;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.lab.rm.engine.core.entities.MongoEntityService;
import org.lab.rm.engine.model.Actor;
import org.lab.rm.engine.model.common.SearchResults;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;

public class ActorEntityService extends MongoEntityService<Actor> {

	@Override
	public SearchResults<Actor> find(String expression, Integer page, Integer count) {
		MongoCollection<Document> collection = getCollection();
		FindIterable<Actor> items;
		if (StringUtils.isNotEmpty(expression)) {
			BsonDocument filter = BsonDocument.parse(expression);
			items = collection.find(filter, Actor.class);
		} else {
			items = collection.find(Actor.class);
		}

		final SearchResults<Actor> result = new SearchResults<>();
		result.setResults(new ArrayList<Actor>());
		items.forEach(new Block<Actor>() {

			@Override
			public void apply(Actor t) {
				result.getResults().add(t);

			}
		});
		return result;
	}

	@Override
	protected String getCollectionName() {
		return "actors";
	}
}
