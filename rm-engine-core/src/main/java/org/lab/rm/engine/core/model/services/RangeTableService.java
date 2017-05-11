package org.lab.rm.engine.core.model.services;

import java.util.Map.Entry;

import org.lab.rm.engine.core.model.RangeTable;

public class RangeTableService {

	public <T> T get(RangeTable<T> table, int value) {
		for (Entry<String, T> entry : table.getValues().entrySet()) {
			int min;
			int max;
			int index = entry.getKey().indexOf(':');
			if (index < 0) {
				min = max = Integer.valueOf(entry.getKey());
			} else {
				min = Integer.parseInt(entry.getKey().substring(0, index));
				max = Integer.parseInt(entry.getKey().substring(index + 1));
			}
			if (value >= min && value <= max) {
				return entry.getValue();
			}
		}
		throw new RuntimeException("Invalid value");
	}

	public <T> T min(RangeTable<T> table) {
		return null;
	}

	public <T> T max(RangeTable<T> table) {
		return null;
	}

}
