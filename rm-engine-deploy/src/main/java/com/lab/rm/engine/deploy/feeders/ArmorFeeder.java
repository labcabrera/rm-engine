package com.lab.rm.engine.deploy.feeders;

import org.bson.Document;
import org.lab.rm.engine.model.items.ArmorType;

import com.mongodb.client.MongoCollection;

import net.sf.flatpack.DataSet;

public class ArmorFeeder extends CsvFeeder {

	@Override
	protected String getCollectionName() {
		return "armor";
	}

	@Override
	protected String getResourceName() {
		return "armor-types.csv";
	}

	@Override
	protected void processRow(DataSet dataSet, MongoCollection<Document> collection) {
		ArmorType entity = new ArmorType();
		entity.setCode(dataSet.getString("CODE"));
		entity.setDescription(dataSet.getString("DESC"));
		collection.insertOne(Document.parse(serializer.toJson(entity)));
	}

}
