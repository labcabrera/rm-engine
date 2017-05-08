package org.lab.rm.engine.core.model.items;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class ArmorType {

	@Id
	private String id;

	private String code;

	private String description;

}
