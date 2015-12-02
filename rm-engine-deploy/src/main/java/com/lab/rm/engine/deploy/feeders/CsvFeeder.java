package com.lab.rm.engine.deploy.feeders;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;
import javax.inject.Provider;

import org.bson.Document;
import org.lab.rm.engine.core.Constants;
import org.lab.rm.engine.core.guice.serialization.Serializer;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;

public abstract class CsvFeeder implements Runnable {

	@Inject
	protected Provider<MongoDatabase> mongoProvider;
	@Inject
	protected Serializer serializer;

	@Override
	public void run() {
		try {
			InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream(getResourceName());
			Reader reader = new InputStreamReader(source, Constants.ENCODING);
			Parser parser = DefaultParserFactory.getInstance().newDelimitedParser(reader, ',', '"');
			DataSet dataSet = parser.parse();
			MongoDatabase mongoDatabase = mongoProvider.get();
			MongoCollection<Document> collection = mongoDatabase.getCollection(getCollectionName());
			while (dataSet.next()) {
				processRow(dataSet, collection);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Feeder error", ex);
		}
	}

	protected abstract String getCollectionName();

	protected abstract String getResourceName();

	protected abstract void processRow(DataSet dataSet, MongoCollection<Document> collection);

}
