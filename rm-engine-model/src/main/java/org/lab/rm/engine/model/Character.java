package org.lab.rm.engine.model;

import java.util.List;

import org.lab.rm.engine.model.common.User;

public class Character {

	private Long id;

	private User owner;

	private String name;

	private Integer level;

	private Gender gender;

	private CharacterClass characterClass;

	private CharacterClass characterRace;

	private CharacterAttributes attributes;

	private Integer maxHitPoints;

	private List<CharacterSkill> skills;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
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

	public CharacterClass getCharacterClass() {
		return characterClass;
	}

	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
	}

	public CharacterClass getCharacterRace() {
		return characterRace;
	}

	public void setCharacterRace(CharacterClass characterRace) {
		this.characterRace = characterRace;
	}

	public Integer getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(Integer maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}
}
