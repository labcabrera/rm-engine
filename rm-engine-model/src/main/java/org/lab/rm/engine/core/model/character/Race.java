package org.lab.rm.engine.core.model.character;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Race {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private LinkedHashMap<AttributeType, Integer> attributes;

	private LinkedHashMap<Resist, Integer> resist;

	private Integer lostSoulTurns;

	private Integer modificarDeterioroCaracteristicas;

	private BigDecimal recuperateMultiplier;

	private Integer initialLanguages;

	/** Dado para PV */
	private Integer pvPoints;

	private Integer maxHitPoints;

}
