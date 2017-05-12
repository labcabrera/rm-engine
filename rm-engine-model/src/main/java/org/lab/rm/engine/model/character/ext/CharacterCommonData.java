package org.lab.rm.engine.model.character.ext;

import java.math.BigDecimal;
import java.util.Map;

import org.lab.rm.engine.model.character.CharacterExtension;
import org.lab.rm.engine.model.character.Gender;

import lombok.Data;

@Data
public class CharacterCommonData implements CharacterExtension {

	public static final String EXT_COMMON_DATA = "commonData";

	private Gender gender;
	private Integer age;
	private BigDecimal weight;
	private BigDecimal height;
	private Map<String, String> notes;

	@Override
	public String name() {
		return EXT_COMMON_DATA;
	}
}
