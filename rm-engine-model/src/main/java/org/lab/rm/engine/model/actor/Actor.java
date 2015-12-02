package org.lab.rm.engine.model.actor;

import java.math.BigDecimal;
import java.util.List;

import org.bson.types.ObjectId;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Entity("actors")
public class Actor {

	@Id
	private ObjectId id;

	@Reference
	private User owner;

	private String name;

	private Race race;

	private ActorClass actorClass;

	private Integer maxLevel;

	private Integer currentLevel;

	private Long xp;

	private Integer maxHitPoints;

	private Gender gender;

	private List<ActorAttribute> attributes;

	private List<ActorSkill> skills;

	private Integer age;

	private BigDecimal weight;

	private BigDecimal height;

	private String notes;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
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

	public Integer getMaxLevel() {
		return maxLevel;
	}

	public void setMaxLevel(Integer maxLevel) {
		this.maxLevel = maxLevel;
	}

	public Integer getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Integer currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Long getXp() {
		return xp;
	}

	public void setXp(Long xp) {
		this.xp = xp;
	}

	public Integer getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(Integer maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
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

	public List<ActorAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<ActorAttribute> attributes) {
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

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
