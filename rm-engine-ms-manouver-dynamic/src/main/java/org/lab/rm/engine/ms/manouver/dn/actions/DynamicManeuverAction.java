package org.lab.rm.engine.ms.manouver.dn.actions;

import org.lab.rm.engine.model.maneuver.DynamicManeuverResult;
import org.lab.rm.engine.model.maneuver.ManeuverDifficulty;

import lombok.Data;

//TODO
@Data
public class DynamicManeuverAction {

	private Integer unmodifiedRandomResult;
	private Integer modifiedRandomResult;

	private ManeuverDifficulty difficulty;

	private DynamicManeuverResult result;

}
