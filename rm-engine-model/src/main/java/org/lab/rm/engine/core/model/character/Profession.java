package org.lab.rm.engine.core.model.character;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.Data;

@Data
public class Profession {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private List<Realm> realms;

}
