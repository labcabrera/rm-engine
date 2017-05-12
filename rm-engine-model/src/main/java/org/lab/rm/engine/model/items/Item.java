package org.lab.rm.engine.model.items;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {

	private ItemType type;

	private String name;

	private Integer units;

	private BigDecimal weigth;

	public Item(String name) {
		this.name = name;
	}

	public Item(String name, Integer units) {
		this.name = name;
		this.units = units;
	}
}
