package org.lab.rm.engine.core.model.character;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;

@Data
public class Realm {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

}
