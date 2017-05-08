package org.lab.rm.engine.core.model.character;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;

import org.lab.rm.engine.core.model.player.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PlayerCharacter {

	@Id
	private String id;

	@Reference
	private Player owner;

	@Indexed(unique = true)
	private String name;

	private Race race;

	private Profession profession;

	private ProfessionRealm realm;

	private Integer maxLevel;

	private Integer currentLevel;

	private Long xp;

	private Integer maxHitPoints;

	private Gender gender;

	private LinkedHashMap<AttributeType, Attribute> attributes;

	private List<CharacterSkill> skills;

	private Integer age;

	private BigDecimal weight;

	private BigDecimal height;

	private String notes;
}
