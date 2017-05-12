package org.lab.rm.engine.core.model.items.repository;

import org.lab.rm.engine.core.model.items.WeaponType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WeaponTypeRepository extends MongoRepository<WeaponType, String> {

	WeaponType findByName(String name);

}
