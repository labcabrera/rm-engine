package org.lab.rm.engine.core.characters;

import java.util.LinkedHashMap;

import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.model.character.Attribute;
import org.lab.rm.engine.model.character.AttributeType;
import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.Profession;
import org.lab.rm.engine.model.character.Race;
import org.lab.rm.engine.model.character.Realm;
import org.lab.rm.engine.model.character.extension.CharacterAttributes;
import org.lab.rm.engine.model.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class PlayerCreationService {

	@Autowired
	private RandomService randomService;

	public PlayerCharacter prepare(Player user, String name, Race raceStats, Profession profession) {
		if (profession.getRealms().size() != 1) {
			throw new RuntimeException("Required realm for profession " + profession.getName());
		}
		return prepare(user, name, raceStats, profession, profession.getRealms().iterator().next());
	}

	public PlayerCharacter prepare(Player user, String name, Race race, Profession profession, Realm realm) {
		Assert.notNull(user, "Player cant be null");
		Assert.notNull(race, "RaceStats cant be null");
		Assert.notNull(profession, "Profession cant be null");
		Assert.notNull(realm, "Realm cant be null");

		PlayerCharacter pj = new PlayerCharacter();
		pj.setOwner(user);
		pj.setName(name);
		pj.setRace(race);
		pj.setProfession(profession);
		pj.setRealm(realm);

		CharacterAttributes attrs = new CharacterAttributes();
		attrs.setAttributes(new LinkedHashMap<AttributeType, Attribute>());
		for (AttributeType i : AttributeType.values()) {
			Attribute a = new Attribute();
			a.setRacialBonus(race.getAttributes().get(i));
			attrs.getAttributes().put(i, a);
		}
		randomizeAttributes(attrs);

		pj.addModule(attrs);
		return pj;
	}

	public void randomizeAttributes(CharacterAttributes attrs) {
		for (Attribute i : attrs.getAttributes().values()) {
			i.setValue(randomService.rand(20, 100));
		}
	}

}
