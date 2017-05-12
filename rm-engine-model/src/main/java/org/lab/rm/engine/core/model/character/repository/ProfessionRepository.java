package org.lab.rm.engine.core.model.character.repository;

import org.lab.rm.engine.core.model.character.Profession;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessionRepository extends MongoRepository<Profession, String> {

	Profession findByName(String name);

}
