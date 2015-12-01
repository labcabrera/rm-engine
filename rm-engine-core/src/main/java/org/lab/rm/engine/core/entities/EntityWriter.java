package org.lab.rm.engine.core.entities;

import org.lab.rm.engine.model.common.Message;

public interface EntityWriter<E> {

	Message<E> persist(E entity);

	Message<E> merge(E entity);

	Message<E> remove(E entity);

}
