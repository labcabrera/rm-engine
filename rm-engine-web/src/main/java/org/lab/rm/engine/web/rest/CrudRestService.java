package org.lab.rm.engine.web.rest;

import java.io.Serializable;

import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.SearchResults;

public interface CrudRestService<E> {

	public E findById(Serializable primaryKey);

	public SearchResults<E> find(String expression, Integer p, Integer c);

	public Message<E> persist(E entity);

	public Message<E> merge(E entity);

	public Message<E> remove(Serializable primaryKey);

}
