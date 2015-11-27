package org.lab.rm.engine.model;

import java.math.BigDecimal;
import java.util.List;

import org.lab.rm.engine.model.common.User;

public class Actor {

	private Long id;

	private User owner;

	private String name;

	private Integer level;

	private Gender gender;

	private ActorClass actorClass;

	private Race race;

	private ActorAttributes attributes;

	private List<ActorSkill> skills;

	private Integer age;

	private BigDecimal weight;

	private BigDecimal height;

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public ActorClass getActorClass() {
		return actorClass;
	}

	public void setActorClass(ActorClass actorClass) {
		this.actorClass = actorClass;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public ActorAttributes getAttributes() {
		return attributes;
	}

	public void setAttributes(ActorAttributes attributes) {
		this.attributes = attributes;
	}

	public List<ActorSkill> getSkills() {
		return skills;
	}

	public void setSkills(List<ActorSkill> skills) {
		this.skills = skills;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}
}
