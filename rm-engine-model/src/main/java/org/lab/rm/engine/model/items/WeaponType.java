package org.lab.rm.engine.model.items;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("weaponTypes")
public class WeaponType extends Item {

	@Id
	private ObjectId id;

	private Float length;

	private Integer flumbe;

	private String breakageNumbers;

	private Integer speed;

	private Integer minStrenghtBonus;

	private String category;

	public Float getLength() {
		return length;
	}

	public void setLength(Float length) {
		this.length = length;
	}

	public Integer getFlumbe() {
		return flumbe;
	}

	public void setFlumbe(Integer flumbe) {
		this.flumbe = flumbe;
	}

	public String getBreakageNumbers() {
		return breakageNumbers;
	}

	public void setBreakageNumbers(String breakageNumbers) {
		this.breakageNumbers = breakageNumbers;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getMinStrenghtBonus() {
		return minStrenghtBonus;
	}

	public void setMinStrenghtBonus(Integer minStrenghtBonus) {
		this.minStrenghtBonus = minStrenghtBonus;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
