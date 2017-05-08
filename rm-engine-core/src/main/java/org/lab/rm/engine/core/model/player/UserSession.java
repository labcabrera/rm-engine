package org.lab.rm.engine.core.model.player;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class UserSession {

	@Id
	private String id;

	private Player user;

}
