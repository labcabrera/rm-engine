package com.lab.rm.engine.deploy.feeders;

import org.bson.Document;
import org.lab.rm.engine.model.Weapon;

import com.mongodb.client.MongoCollection;

import net.sf.flatpack.DataSet;

public class WeaponFeeder extends CsvFeeder {

	@Override
	protected String getCollectionName() {
		return "armor";
	}

	@Override
	protected String getResourceName() {
		return "weapons.csv";
	}

	@Override
	protected void processRow(DataSet dataSet, MongoCollection<Document> collection) {
		Weapon entity = new Weapon();
		entity.setName(dataSet.getString("NAME"));
		collection.insertOne(Document.parse(serializer.toJson(entity)));
	}

}
