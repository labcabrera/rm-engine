package org.lab.rm.engine.model.table.repository;

import org.lab.rm.engine.model.table.SingleEntryTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SingleEntryTableRepository extends MongoRepository<SingleEntryTable, String> {

	SingleEntryTable findByName(String name);

}
