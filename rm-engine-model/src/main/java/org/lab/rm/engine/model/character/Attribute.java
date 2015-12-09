package org.lab.rm.engine.model.character;

public class Attribute {

	private Integer value;

	private Integer baseBonus;

	private Integer racialBonus;

	private Integer totalBonus;

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Integer getBaseBonus() {
		return baseBonus;
	}

	public void setBaseBonus(Integer baseBonus) {
		this.baseBonus = baseBonus;
	}

	public Integer getRacialBonus() {
		return racialBonus;
	}

	public void setRacialBonus(Integer racialBonus) {
		this.racialBonus = racialBonus;
	}

	public Integer getTotalBonus() {
		return totalBonus;
	}

	public void setTotalBonus(Integer totalBonus) {
		this.totalBonus = totalBonus;
	}
}
