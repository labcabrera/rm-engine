package org.lab.rm.engine.model.character;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;

@Entity("raceStats")
public class RaceStats {

	private ObjectId id;

	private Race race;

	private LinkedHashMap<AttributeType, Integer> attributes;

	private LinkedHashMap<Resist, Integer> resist;

	private Integer lostSoulTurns;

	private Integer modificarDeterioroCaracteristicas;

	private BigDecimal recuperateMultiplier;

	private Integer initialLanguages;

	/** Dado para PV */
	private Integer pvPoints;

	private Integer maxHitPoints;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public LinkedHashMap<AttributeType, Integer> getAttributes() {
		return attributes;
	}

	public void setAttributes(LinkedHashMap<AttributeType, Integer> attributes) {
		this.attributes = attributes;
	}

	public LinkedHashMap<Resist, Integer> getResist() {
		return resist;
	}

	public void setResist(LinkedHashMap<Resist, Integer> resist) {
		this.resist = resist;
	}

	public Integer getLostSoulTurns() {
		return lostSoulTurns;
	}

	public void setLostSoulTurns(Integer lostSoulTurns) {
		this.lostSoulTurns = lostSoulTurns;
	}

	public Integer getModificarDeterioroCaracteristicas() {
		return modificarDeterioroCaracteristicas;
	}

	public void setModificarDeterioroCaracteristicas(Integer modificarDeterioroCaracteristicas) {
		this.modificarDeterioroCaracteristicas = modificarDeterioroCaracteristicas;
	}

	public BigDecimal getRecuperateMultiplier() {
		return recuperateMultiplier;
	}

	public void setRecuperateMultiplier(BigDecimal recuperateMultiplier) {
		this.recuperateMultiplier = recuperateMultiplier;
	}

	public Integer getInitialLanguages() {
		return initialLanguages;
	}

	public void setInitialLanguages(Integer initialLanguages) {
		this.initialLanguages = initialLanguages;
	}

	public Integer getPvPoints() {
		return pvPoints;
	}

	public void setPvPoints(Integer pvPoints) {
		this.pvPoints = pvPoints;
	}

	public Integer getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(Integer maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

}
