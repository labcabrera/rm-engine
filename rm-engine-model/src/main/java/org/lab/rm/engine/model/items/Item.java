package org.lab.rm.engine.model.items;

import java.math.BigDecimal;

public class Item {

	private ItemType type;

	private String name;

	private Integer units;

	private BigDecimal weigth;

	public Item() {
	}

	public Item(String name) {
		this.name = name;
	}

	public Item(String name, Integer units) {
		this.name = name;
		this.units = units;
	}

	public ItemType getType() {
		return type;
	}

	public void setType(ItemType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public BigDecimal getWeigth() {
		return weigth;
	}

	public void setWeigth(BigDecimal weigth) {
		this.weigth = weigth;
	}

}
