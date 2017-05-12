package org.lab.rm.engine.core.model.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class WeaponType extends Item {

	@Id
	private String id;

	private Float length;

	private Integer flumbe;

	private String breakageNumbers;

	private Integer speed;

	private Integer minStrenghtBonus;

	private String category;

}
