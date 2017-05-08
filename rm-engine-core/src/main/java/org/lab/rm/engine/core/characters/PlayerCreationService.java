package org.lab.rm.engine.core.characters;

import java.util.LinkedHashMap;

import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.core.model.character.Attribute;
import org.lab.rm.engine.core.model.character.AttributeType;
import org.lab.rm.engine.core.model.character.PlayerCharacter;
import org.lab.rm.engine.core.model.character.Profession;
import org.lab.rm.engine.core.model.character.ProfessionRealm;
import org.lab.rm.engine.core.model.character.Race;
import org.lab.rm.engine.core.model.character.RaceStats;
import org.lab.rm.engine.core.model.character.repository.PlayerCharacterRepository;
import org.lab.rm.engine.core.model.character.repository.RaceStatsRepository;
import org.lab.rm.engine.core.model.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PlayerCreationService {

	@Autowired
	private RandomService randomService;
	@Autowired
	private PlayerCharacterRepository playerCharacterRepository;
	@Autowired
	private RaceStatsRepository raceStatsRepository;

	public PlayerCharacter prepare(Player user, String name, Race race, Profession profession, ProfessionRealm realm) {
		Assert.notNull(user, "Player cant be null");
		Assert.notNull(race, "Race cant be null");
		Assert.notNull(profession, "Profession cant be null");
		Assert.notNull(realm, "Realm cant be null");

		RaceStats raceStats = raceStatsRepository.findByRace(race);

		PlayerCharacter pj = new PlayerCharacter();
		pj.setOwner(user);
		pj.setName(name);
		pj.setRace(race);
		pj.setProfession(profession);
		pj.setRealm(realm);
		pj.setAttributes(new LinkedHashMap<AttributeType, Attribute>());
		for (AttributeType i : AttributeType.values()) {
			Attribute a = new Attribute();
			a.setRacialBonus(raceStats.getAttributes().get(i));
			pj.getAttributes().put(i, a);
		}
		randomizeAttributes(pj);
		return pj;
	}

	public void randomizeAttributes(PlayerCharacter pj) {
		for (Attribute i : pj.getAttributes().values()) {
			i.setValue(randomService.rand(20, 100));
		}
	}

}
