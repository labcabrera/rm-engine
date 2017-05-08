package org.lab.rm.engine.core.combat;

import org.lab.rm.engine.core.model.character.CharacterContext;
import org.lab.rm.engine.core.model.combat.AttackBonus;
import org.lab.rm.engine.core.model.combat.DefenseBonus;

public class CombatManager {

	public void setUpBonus(CharacterContext pjContext) {
		pjContext.setDefenseBonus(calculateDefenseBonus());
		pjContext.setOffenseBonus(calculateAttackBonus());
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
