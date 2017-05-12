package org.lab.rm.engine.model.character.extension;

import java.math.BigDecimal;
import java.util.Map;

import org.lab.rm.engine.model.character.Gender;

import lombok.Data;

@Data
public class CharacterCommonData implements CharacterExtension {

	private Gender gender;
	private Integer age;
	private BigDecimal weight;
	private BigDecimal height;
	private Map<String, String> notes;

	@Override
	public String name() {
		return CharacterExtension.COMMON_DATA;
	}
}
