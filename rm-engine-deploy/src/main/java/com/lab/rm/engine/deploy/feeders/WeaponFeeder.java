package com.lab.rm.engine.deploy.feeders;

import org.bson.Document;
import org.lab.rm.engine.model.items.WeaponType;

import com.mongodb.client.MongoCollection;

import net.sf.flatpack.DataSet;

public class WeaponFeeder extends CsvFeeder {

	@Override
	protected String getCollectionName() {
		return WeaponType.COLLECTION_NAME;
	}

	@Override
	protected String getResourceName() {
		return "weapons.csv";
	}

	@Override
	protected void processRow(DataSet dataSet, MongoCollection<Document> collection) {
		WeaponType entity = new WeaponType();
		entity.setName(dataSet.getString("NAME"));
		collection.insertOne(Document.parse(serializer.toJson(entity)));
	}

}
