package org.lab.rm.engine.model.items.repository;

import org.lab.rm.engine.model.items.WeaponType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeaponTypeRepository extends MongoRepository<WeaponType, String> {

	WeaponType findByName(String name);

}
