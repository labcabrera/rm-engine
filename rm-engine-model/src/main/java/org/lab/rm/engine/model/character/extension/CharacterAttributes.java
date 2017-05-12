package org.lab.rm.engine.model.character.extension;

import java.util.LinkedHashMap;

import org.lab.rm.engine.model.character.Attribute;
import org.lab.rm.engine.model.character.AttributeType;

import lombok.Data;

@Data
public class CharacterAttributes implements CharacterExtension {

	private LinkedHashMap<AttributeType, Attribute> attributes;

	@Override
	public String name() {
		return CharacterExtension.ATTRIBUTES;
	}

}
