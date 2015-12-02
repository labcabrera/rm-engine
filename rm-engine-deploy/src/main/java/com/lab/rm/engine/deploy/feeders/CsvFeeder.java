package com.lab.rm.engine.deploy.feeders;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.inject.Inject;
import javax.inject.Provider;

import org.lab.rm.engine.core.Constants;
import org.mongodb.morphia.Datastore;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;

public abstract class CsvFeeder<T> implements Runnable {

	@Inject
	protected Provider<Datastore> datastoreProvider;

	@Override
	public void run() {
		try {
			InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream(getResourceName());
			Reader reader = new InputStreamReader(source, Constants.ENCODING);
			Parser parser = DefaultParserFactory.getInstance().newDelimitedParser(reader, ',', '"');
			DataSet dataSet = parser.parse();
			Datastore datastore = datastoreProvider.get();
			while (dataSet.next()) {
				T entity = parseRow(dataSet);
				datastore.save(entity);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Feeder error", ex);
		}
	}

	protected abstract String getResourceName();

	protected abstract T parseRow(DataSet dataSet);

}
