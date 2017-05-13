package org.lab.rm.engine.ms.common.controller;

import org.lab.rm.engine.model.movement.ManeuverDifficulty;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enumeration")
public class EnumController {

	@RequestMapping(value = "movementDifficulty", method = RequestMethod.GET)
	public ManeuverDifficulty[] values() {
		return ManeuverDifficulty.values();

	}

}
