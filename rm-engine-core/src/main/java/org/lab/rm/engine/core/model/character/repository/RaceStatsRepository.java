package org.lab.rm.engine.core.model.character.repository;

import org.lab.rm.engine.core.model.character.Race;
import org.lab.rm.engine.core.model.character.RaceStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RaceStatsRepository extends MongoRepository<RaceStats, String> {

	RaceStats findByRace(Race race);

}
