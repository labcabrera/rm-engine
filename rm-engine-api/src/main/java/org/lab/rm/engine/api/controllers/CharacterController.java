package org.lab.rm.engine.api.controllers;

import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.repository.PlayerCharacterRepository;
import org.lab.rm.engine.model.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/character")
@Api(tags = { "Player character operations" })
public class CharacterController {

	@Autowired
	private PlayerCharacterRepository repository;

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public PlayerCharacter find(Player owner, String name) {
		return repository.findByOwnerAndName(owner, name);
	}

}
