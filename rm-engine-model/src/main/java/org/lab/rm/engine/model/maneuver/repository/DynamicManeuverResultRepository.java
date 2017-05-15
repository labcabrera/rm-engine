package org.lab.rm.engine.model.maneuver.repository;

import org.lab.rm.engine.model.maneuver.DynamicManeuverResult;
import org.lab.rm.engine.model.maneuver.ManeuverDifficulty;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DynamicManeuverResultRepository extends MongoRepository<DynamicManeuverResult, String> {

	@Query("{ 'min': { $lte: ?0 }, 'max': {$gte: ?0}, 'difficulty': ?1}")
	DynamicManeuverResult findByRange(int value, ManeuverDifficulty dificulty);

}
