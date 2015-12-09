package org.lab.rm.engine.core.characters;

import java.util.LinkedHashMap;

import javax.inject.Inject;

import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.model.character.Attribute;
import org.lab.rm.engine.model.character.AttributeType;
import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.Profession;
import org.lab.rm.engine.model.character.ProfessionRealm;
import org.lab.rm.engine.model.character.Race;
import org.lab.rm.engine.model.character.RaceStats;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

public class PlayerCreationService {

	@Inject
	private RandomService randomService;
	@Inject
	private Datastore datastore;

	public PlayerCharacter prepare(User user, String name, Race race, Profession profession, ProfessionRealm realm) {
		RaceStats raceStats = datastore.find(RaceStats.class, "race", race.name()).iterator().next();

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
