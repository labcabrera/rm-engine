package org.lab.rm.engine.core.entities;

import java.io.Serializable;

import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;

public abstract class EntityService<T> {

	public T findById(Serializable primaryKey) {
		return null;
	}

	public SearchResults<T> find(String query, Integer count, Integer page) {
		return null;
	}

	public Message<T> merge(T t) {
		return null;
	}

	public Message<T> remove(Serializable primaryKey) {
		return null;
	}
}
