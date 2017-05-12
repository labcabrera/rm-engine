package org.lab.rm.engine.model.character.extension;

import lombok.Data;

@Data
public class CharacterHitPointsInfo implements CharacterExtension {

	private Integer maxHitPoints;
	private Integer currentHitPoints;

	@Override
	public String name() {
		return CharacterExtension.HP;
	}

}
