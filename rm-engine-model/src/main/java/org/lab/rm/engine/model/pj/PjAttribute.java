package org.lab.rm.engine.model.pj;

public class PjAttribute {

	private AttributeType type;

	private Integer value;

	private Integer baseBonus;

	private Integer racialBonus;

	private Integer totalBonus;

	public PjAttribute() {
	}

	public PjAttribute(AttributeType type, Integer value) {
		this.type = type;
		this.value = value;
		this.racialBonus = 0;
	}

	public AttributeType getType() {
		return type;
	}

	public void setType(AttributeType type) {
		this.type = type;
	}

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
