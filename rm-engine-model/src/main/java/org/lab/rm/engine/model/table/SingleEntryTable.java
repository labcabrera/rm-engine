package org.lab.rm.engine.model.table;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;

@Data
public class SingleEntryTable {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private Map<String, String> values;

	private Boolean condensed;

	public String get(String key) {
		return values.get(key);
	}

}
