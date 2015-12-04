package org.lab.rm.engine.core.combat;

import org.lab.rm.engine.model.combat.AttackBonus;
import org.lab.rm.engine.model.combat.DefenseBonus;
import org.lab.rm.engine.model.pj.PjContext;

public class CombatManager {

	public void setUpBonus(PjContext pjContext) {
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
