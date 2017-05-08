package com.lab.rm.engine.deploy.feeders;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;

import org.lab.rm.engine.core.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;

public abstract class CsvFeeder<T, I extends Serializable> implements Runnable {

	@Autowired
	private MongoRepository<T, I> repository;

	@Override
	public void run() {
		try {
			InputStream source = Thread.currentThread().getContextClassLoader().getResourceAsStream(getResourceName());
			Reader reader = new InputStreamReader(source, Constants.ENCODING);
			Parser parser = DefaultParserFactory.getInstance().newDelimitedParser(reader, ',', '"');
			DataSet dataSet = parser.parse();
			// Datastore datastore = datastoreProvider.get();
			while (dataSet.next()) {
				T entity = parseRow(dataSet);
				repository.save(entity);
			}
		} catch (Exception ex) {
			throw new RuntimeException("Feeder error", ex);
		}
	}

	protected abstract String getResourceName();

	protected abstract T parseRow(DataSet dataSet);

}
