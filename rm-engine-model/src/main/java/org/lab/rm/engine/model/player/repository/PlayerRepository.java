package org.lab.rm.engine.model.player.repository;

import org.lab.rm.engine.model.player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String> {

	Player findByName(String name);

}
