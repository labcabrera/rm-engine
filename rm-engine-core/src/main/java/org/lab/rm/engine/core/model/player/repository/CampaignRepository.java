package org.lab.rm.engine.core.model.player.repository;

import org.lab.rm.engine.core.model.player.Campaign;
import org.lab.rm.engine.core.model.player.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CampaignRepository extends MongoRepository<Campaign, String> {

	Player findByName(String name);

}
