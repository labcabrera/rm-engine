package com.lab.rm.engine.deploy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;
import javax.inject.Provider;

import org.bson.Document;
import org.lab.rm.engine.core.Constants;
import org.lab.rm.engine.core.guice.serialization.Serializer;
import org.lab.rm.engine.model.ArmorType;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;

public class ArmorTypeFeeder implements Runnable {

	@Inject
	private Provider<MongoDatabase> mongoProvider;
	@Inject
	private Serializer serializer;

	@Override
	public void run() {
		try {
			InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream("armor-types.csv");
			Reader reader = new InputStreamReader(source, Constants.ENCODING);
			Parser parser = DefaultParserFactory.getInstance().newDelimitedParser(reader, ',', '"');
			DataSet dataSet = parser.parse();
			MongoDatabase mongoDatabase = mongoProvider.get();
			MongoCollection<Document> collection = mongoDatabase.getCollection("armor_types");
			while (dataSet.next()) {
				ArmorType entity = new ArmorType();
				entity.setCode(dataSet.getString("Armor type"));
				entity.setDescription(dataSet.getString("Notes"));
				collection.insertOne(Document.parse(serializer.toJson(entity)));
			}
		} catch (Exception ex) {
			throw new RuntimeException("Armor feeder error", ex);
		}
	}

}
