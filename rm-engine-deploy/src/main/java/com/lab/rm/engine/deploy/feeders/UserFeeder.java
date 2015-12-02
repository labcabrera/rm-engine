package com.lab.rm.engine.deploy.feeders;

import org.apache.commons.codec.digest.DigestUtils;
import org.bson.Document;
import org.lab.rm.engine.model.user.User;

import com.mongodb.client.MongoCollection;

import net.sf.flatpack.DataSet;

public class UserFeeder extends CsvFeeder {

	@Override
	protected String getCollectionName() {
		return "users";
	}

	@Override
	protected String getResourceName() {
		return "users.csv";
	}

	@Override
	protected void processRow(DataSet dataSet, MongoCollection<Document> collection) {
		User user = new User();
		user.setName(dataSet.getString("NAME"));
		user.setEmail(dataSet.getString("EMAIL"));
		user.setPasswordDigest(DigestUtils.sha256Hex(dataSet.getString("PASSWORD")));
		collection.insertOne(Document.parse(serializer.toJson(user)));
	}
}
