package org.lab.rm.engine.ms.manouver.dn.controllers;

import org.lab.rm.engine.model.maneuver.DynamicManeuverResult;
import org.lab.rm.engine.model.maneuver.ManeuverDifficulty;
import org.lab.rm.engine.ms.manouver.dn.actions.DynamicManeuverAction;
import org.lab.rm.engine.ms.manouver.dn.services.DynamicManeuverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "maneuver/dynamic")
public class DynamicManeuverController {

	@Autowired
	private DynamicManeuverService service;

	@RequestMapping(value = "/prepare", method = RequestMethod.GET)
	public DynamicManeuverAction prepare() {
		return new DynamicManeuverAction();
	}

	@RequestMapping(value = "/execute", method = RequestMethod.POST)
	public DynamicManeuverAction execute(DynamicManeuverAction action) {
		Integer modifiedResult = action.getModifiedRandomResult();
		ManeuverDifficulty difficulty = action.getDifficulty();
		DynamicManeuverResult result = service.find(modifiedResult, difficulty);
		action.setResult(result);
		return action;
	}

}
