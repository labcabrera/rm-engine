package org.lab.rm.engine.model.movement.repository;

import org.lab.rm.engine.model.movement.ManeuverDifficulty;
import org.lab.rm.engine.model.movement.MovementManeuverResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MovementManeuverResultRepository extends MongoRepository<MovementManeuverResult, String> {

	@Query("{ 'min': { $lte: ?0 }, 'max': {$gte: ?0}, 'difficulty': ?1}")
	MovementManeuverResult findByRange(int value, ManeuverDifficulty dificulty);

}
