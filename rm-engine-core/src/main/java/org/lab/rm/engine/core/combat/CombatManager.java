package org.lab.rm.engine.core.combat;

import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.extension.CharacterCombatContext;
import org.lab.rm.engine.model.character.extension.CharacterExtension;
import org.lab.rm.engine.model.combat.AttackBonus;
import org.lab.rm.engine.model.combat.DefenseBonus;

public class CombatManager {

	public void setUpBonus(PlayerCharacter character) {
		CharacterCombatContext ctx = character.getModule(CharacterExtension.COMBAT_CONTEXT,
				CharacterCombatContext.class);
		ctx.setDefenseBonus(calculateDefenseBonus());
		ctx.setOffenseBonus(calculateAttackBonus());
	}

	private DefenseBonus calculateDefenseBonus() {
		DefenseBonus bonus = new DefenseBonus();
		return bonus;
	}

	private AttackBonus calculateAttackBonus() {
		AttackBonus bonus = new AttackBonus();
		return bonus;
	}

}
