package org.lab.rm.engine.ms.manouver.dn.services;

import org.lab.rm.engine.model.maneuver.DynamicManeuverResult;
import org.lab.rm.engine.model.maneuver.ManeuverDifficulty;
import org.lab.rm.engine.model.maneuver.repository.DynamicManeuverResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicManeuverService {

	@Autowired
	private DynamicManeuverResultRepository repository;

	public DynamicManeuverResult find(int value, ManeuverDifficulty difficulty) {
		return repository.findByRange(value, difficulty);
	}

}
