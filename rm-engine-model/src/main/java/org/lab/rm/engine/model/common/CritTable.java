package org.lab.rm.engine.model.common;

import java.util.Map;

import org.lab.rm.engine.model.items.ArmorType;

public class CritTable {

	private CritType type;

	private Map<ArmorType, String> data;

	public CritType getType() {
		return type;
	}

	public void setType(CritType type) {
		this.type = type;
	}

	public Map<ArmorType, String> getData() {
		return data;
	}

	public void setData(Map<ArmorType, String> data) {
		this.data = data;
	}
}
