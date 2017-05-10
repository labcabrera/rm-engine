package org.lab.rm.engine.api.controllers;

import org.lab.rm.engine.core.model.player.Player;
import org.lab.rm.engine.core.model.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/player")
@Api(tags = { "Player operations" })
public class PlayerController {

	@Autowired
	private PlayerRepository repository;

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public Player find(@RequestParam(name = "name") String name) {
		return repository.findByName(name);
	}

}
