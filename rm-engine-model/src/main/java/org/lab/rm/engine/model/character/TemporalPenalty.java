package org.lab.rm.engine.model.character;

public class TemporalPenalty {

	private PenaltyType type;

	private Integer turnsTotal;

	private Integer turnsRemaining;

	private Integer value;

	private String description;

	public PenaltyType getType() {
		return type;
	}

	public void setType(PenaltyType type) {
		this.type = type;
	}

	public Integer getTurnsTotal() {
		return turnsTotal;
	}

	public void setTurnsTotal(Integer turnsTotal) {
		this.turnsTotal = turnsTotal;
	}

	public Integer getTurnsRemaining() {
		return turnsRemaining;
	}

	public void setTurnsRemaining(Integer turnsRemaining) {
		this.turnsRemaining = turnsRemaining;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
