package org.lab.rm.engine.core.model.character;

import java.math.BigDecimal;
import java.util.Map;

import lombok.Data;

@Data
public class CharacterCommonData {

	private Gender gender;
	private Integer age;
	private BigDecimal weight;
	private BigDecimal height;
	private Map<String, String> notes;
}
