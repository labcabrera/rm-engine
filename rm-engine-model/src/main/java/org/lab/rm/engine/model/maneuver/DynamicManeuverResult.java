package org.lab.rm.engine.model.maneuver;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "tableMovementManeuverEntry")
@Data
public class DynamicManeuverResult {

	private String id;

	@Indexed
	private Integer min;
	@Indexed
	private Integer max;
	@Indexed
	private ManeuverDifficulty difficulty;

	private String desc;
	private Integer percent;
	private Integer hp;

}
