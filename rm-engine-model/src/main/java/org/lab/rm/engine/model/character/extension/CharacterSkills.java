package org.lab.rm.engine.model.character.extension;

import java.util.Map;

import org.lab.rm.engine.model.character.CharacterSkill;
import org.lab.rm.engine.model.character.Skill;

import lombok.Data;

@Data
public class CharacterSkills implements CharacterExtension {

	private Map<Skill, CharacterSkill> values;

	@Override
	public String name() {
		return CharacterExtension.SKILLS;
	}

}
