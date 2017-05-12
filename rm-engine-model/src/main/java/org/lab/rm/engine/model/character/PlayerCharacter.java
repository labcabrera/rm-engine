package org.lab.rm.engine.model.character;

import java.util.HashMap;
import java.util.Map;

import org.lab.rm.engine.model.character.extension.CharacterExtension;
import org.lab.rm.engine.model.player.Player;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
// TODO Index (owner,name)
public class PlayerCharacter {

	@Id
	private String id;

	@Reference
	private Player owner;

	private String name;

	@Reference
	private Race race;

	@Reference
	private Profession profession;

	@Reference
	private Realm realm;

	private Map<String, CharacterExtension> modules;

	public void addModule(CharacterExtension module) {
		if (modules == null) {
			modules = new HashMap<>();
		}
		modules.put(module.name(), module);
	}

	@SuppressWarnings("unchecked")
	public <T> T getModule(String name, Class<T> moduleClass) {
		return (T) modules.get(name);

	}
}
