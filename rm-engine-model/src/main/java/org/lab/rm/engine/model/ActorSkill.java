package org.lab.rm.engine.model;

public class ActorSkill {

	private Skill skill;

	private Integer skillLevel;

	private Integer bonus;

	private Integer racialBonus;

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getRacialBonus() {
		return racialBonus;
	}

	public void setRacialBonus(Integer racialBonus) {
		this.racialBonus = racialBonus;
	}
}
