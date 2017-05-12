package org.lab.rm.engine.model.character.extension;

import lombok.Data;

@Data
public class CharacterExperience implements CharacterExtension {

	private Integer level;
	private Integer currentLevel;
	private Long xp;

	@Override
	public String name() {
		return CharacterExtension.EXPERIENCE;
	}

}
