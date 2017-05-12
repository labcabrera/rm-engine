package org.lab.rm.engine.model.character.extension;

public interface CharacterExtension {

	// Main extension names:

	String COMMON_DATA = "commonData";
	String ATTRIBUTES = "attributes";
	String SKILLS = "skills";
	String EXPERIENCE = "experience";
	String HP = "hp";
	String MOVEMENT = "movement";
	String INVENTORY = "inventory";

	String COMBAT_CONTEXT = "context";

	String name();

}
