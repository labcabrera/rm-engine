package org.lab.rm.engine.core.model.character.repository;

import org.lab.rm.engine.core.model.character.PlayerCharacter;
import org.lab.rm.engine.core.model.player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerCharacterRepository extends MongoRepository<PlayerCharacter, String> {

	PlayerCharacter findByOwnerAndName(Player owner, String name);

}
