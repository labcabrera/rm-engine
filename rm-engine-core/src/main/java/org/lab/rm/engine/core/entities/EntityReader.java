package org.lab.rm.engine.core.entities;

import java.io.Serializable;

import org.lab.rm.engine.model.common.SearchResults;

public interface EntityReader<E> {

	E findByPrimaryKey(Serializable primaryKey);

	SearchResults<E> find(String expression, Integer page, Integer count);

}
