package org.lab.rm.engine.model;

public class Character {

	private Long id;

	private String name;

	private Integer level;

	private CharacterClass characterClass;

	private CharacterClass characterRace;

	private Integer maxHitPoints;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
