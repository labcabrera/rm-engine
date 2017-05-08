package org.lab.rm.engine.core.model.character.repository;

import org.lab.rm.engine.core.model.character.CharacterContext;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharacterContextRepository extends MongoRepository<CharacterContext, String> {

}
