package org.lab.rm.engine.model.character;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.lab.rm.engine.model.character.ext.CharacterCommonData;
import org.lab.rm.engine.model.player.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class PlayerCharacter {

	@Id
	private String id;

	@Reference
	private Player owner;

	// @Indexed(unique = true)
	private String name;

	@Reference
	private Race race;

	@Reference
	private Profession profession;

	@Reference
	private Realm realm;

	private Map<String, CharacterExtension> modules;

	private LinkedHashMap<AttributeType, Attribute> attributes;
	private List<CharacterSkill> skills;

	private CharacterHitPointsInfo hitPointsInfo;
	private CharacterExperience experience;
//	private CharacterCommonData commonData;
	private CharacterMovementInfo movementInfo;

	private Integer maxHitPoints;

	public void addModule(CharacterExtension module) {
		if (modules == null) {
			modules = new HashMap<>();
		}
		modules.put(module.name(), module);
	}
}
