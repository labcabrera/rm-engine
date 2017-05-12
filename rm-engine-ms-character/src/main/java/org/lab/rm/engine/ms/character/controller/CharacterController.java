package org.lab.rm.engine.ms.character.controller;

import java.util.List;

import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.repository.PlayerCharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/characters")
public class CharacterController {

	@Autowired
	private PlayerCharacterRepository repository;

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public List<PlayerCharacter> find() {
		return repository.findAll();
	}
}
