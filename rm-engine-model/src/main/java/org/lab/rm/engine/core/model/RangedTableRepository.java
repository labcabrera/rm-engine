package org.lab.rm.engine.core.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RangedTableRepository<T> extends MongoRepository<RangeTable<T>, String> {

	RangeTable<T> findByName(String name);

}
