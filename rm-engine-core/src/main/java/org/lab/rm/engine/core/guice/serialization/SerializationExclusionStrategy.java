package org.lab.rm.engine.core.guice.serialization;

import org.lab.rm.engine.model.annotations.NotSerializable;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class SerializationExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(NotSerializable.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return clazz.getAnnotation(NotSerializable.class) != null;
	}

}
