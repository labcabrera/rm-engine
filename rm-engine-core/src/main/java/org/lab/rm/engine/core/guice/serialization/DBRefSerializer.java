package org.lab.rm.engine.core.guice.serialization;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mongodb.DBRef;

public class DBRefSerializer implements JsonSerializer<DBRef> {

	@Override
	public JsonElement serialize(DBRef src, Type typeOfSrc, JsonSerializationContext context) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("$ref", src.getCollectionName());
		jsonObject.addProperty("$id", src.getId().toString());
		return jsonObject;
	}

}
