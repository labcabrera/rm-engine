package org.lab.rm.engine.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;
import org.bson.BsonDocument;
import org.bson.Document;
import org.lab.rm.engine.core.Constants;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Path("entity")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EntityRestService {

	@Inject
	private Provider<MongoClient> mongoProvider;

	@GET
	@Path("find/{name}")
	public List<Document> find(@PathParam("name") String name, @QueryParam("q") String expression, @QueryParam("q") Integer p, @QueryParam("q") Integer c) {
		MongoClient mongoClient = mongoProvider.get();
		MongoDatabase mongoDatabase = mongoClient.getDatabase(Constants.DATABASE);
		MongoCollection<Document> collection = mongoDatabase.getCollection(name);
		FindIterable<Document> find;
		if (StringUtils.isNotBlank(expression)) {
			find = collection.find(BsonDocument.parse(expression));
		} else {
			find = collection.find();
		}
		final List<Document> list = new ArrayList<>();
		find.forEach(new Block<Document>() {

			@Override
			public void apply(Document t) {
				list.add(t);
			}
		});
		return list;

	}

}
