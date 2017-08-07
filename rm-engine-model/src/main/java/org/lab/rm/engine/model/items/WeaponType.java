package org.lab.rm.engine.model.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Document
@Data
@EqualsAndHashCode(callSuper = true)
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
