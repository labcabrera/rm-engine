package org.lab.rm.engine.core.guice.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Componente encargado de serializar y deserializar las entidades utilizando JSON.
 */
public class Serializer {

	private static final Logger LOG = LoggerFactory.getLogger(Serializer.class);

	private static final String ENCODING = "UTF-8";
	private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";

	public <T> GsonBuilder getBuilder() {
		GsonBuilder builder = new GsonBuilder();
		builder.setPrettyPrinting();
		builder.addSerializationExclusionStrategy(new SerializationExclusionStrategy());
		builder.setDateFormat(DATE_FORMAT_PATTERN);
		return builder;
	}

	public void serialize(Object object, OutputStream entityStream) {
		try {
			Gson gson = getBuilder().create();
			String json = gson.toJson(object);
			entityStream.write(json.getBytes(ENCODING));
		} catch (Exception ex) {
			LOG.error("Serialization error: {}", ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	public String toJson(Object object) {
		try {
			return getBuilder().create().toJson(object);
		} catch (Exception ex) {
			LOG.error("Serialization error: {}", ex.getMessage());
			throw new RuntimeException(ex);
		}
	}

	public <T> T deserialize(Class<T> type, InputStream entityStream) {
		InputStreamReader streamReader = null;
		try {
			streamReader = new InputStreamReader(entityStream, ENCODING);
			Type jsonType = type;
			return getBuilder().create().fromJson(streamReader, jsonType);
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		} finally {
			if (streamReader != null) {
				try {
					streamReader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

	public <T> T deserialize(Class<T> type, String json) {
		InputStreamReader streamReader = null;
		try {
			Type jsonType = type;
			return getBuilder().create().fromJson(json, jsonType);
		} finally {
			if (streamReader != null) {
				try {
					streamReader.close();
				} catch (IOException ignore) {
				}
			}
		}
	}

}
