package org.lab.rm.engine.model;

import java.util.LinkedHashMap;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class RangeTable<T> {

	@Id
	private String name;

	private LinkedHashMap<String, T> values;

}
