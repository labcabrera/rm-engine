package org.lab.rm.engine.core.services.movement;

import org.lab.rm.engine.model.movement.ManeuverDifficulty;
import org.lab.rm.engine.model.movement.MovementManeuverResult;
import org.lab.rm.engine.model.movement.repository.MovementManeuverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovementManeuverService {

	@Autowired
	private MovementManeuverResultRepository repository;

	public MovementManeuverResult find(int value, ManeuverDifficulty difficulty) {
		return repository.findByRange(value, difficulty);
	}

}
