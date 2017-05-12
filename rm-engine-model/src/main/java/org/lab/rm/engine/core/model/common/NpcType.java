package org.lab.rm.engine.core.model.common;

import java.util.List;

import org.bson.types.ObjectId;
import org.lab.rm.engine.core.model.items.ArmorType;

public class NpcType {

	private ObjectId id;

	private String name;

	private Integer level;

	private ArmorType armor;

	private List<AttackInfo> attacks;

	private String notes;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public ArmorType getArmor() {
		return armor;
	}

	public void setArmor(ArmorType armor) {
		this.armor = armor;
	}

	public List<AttackInfo> getAttacks() {
		return attacks;
	}

	public void setAttacks(List<AttackInfo> attacks) {
		this.attacks = attacks;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
