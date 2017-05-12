package org.lab.rm.engine.model.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class Player {

	@Id
	private String id;

	private String name;

	private String email;

	private String passwordDigest;

	public Player(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
