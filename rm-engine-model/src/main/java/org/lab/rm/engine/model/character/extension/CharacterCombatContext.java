package org.lab.rm.engine.model.character.extension;

import org.lab.rm.engine.model.combat.AttackBonus;
import org.lab.rm.engine.model.combat.DefenseBonus;

import lombok.Data;

@Data
public class CharacterCombatContext implements CharacterExtension {

	private DefenseBonus defenseBonus;
	private AttackBonus offenseBonus;

	@Override
	public String name() {
		return CharacterExtension.COMBAT_CONTEXT;
	}

}
