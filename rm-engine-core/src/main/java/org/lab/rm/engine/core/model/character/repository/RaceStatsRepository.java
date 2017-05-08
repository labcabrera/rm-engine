package org.lab.rm.engine.core.model.character.repository;

import org.lab.rm.engine.core.model.character.Race;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RaceStatsRepository extends MongoRepository<Race, String> {

	Race findByName(String name);

}
