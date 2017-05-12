package org.lab.rm.engine.model.player;

import java.util.List;

import org.lab.rm.engine.model.character.extension.CharacterInventory;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Campaign {

	@Id
	private String id;

	@Reference
	private Player owner;

	private String name;

	@Reference
	private List<CharacterInventory> actors;

}
