package org.lab.rm.engine.core.pj;

import java.util.LinkedHashMap;

import javax.inject.Inject;

import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.model.pj.AttributeType;
import org.lab.rm.engine.model.pj.Attribute;
import org.lab.rm.engine.model.pj.Pj;
import org.lab.rm.engine.model.pj.Profession;
import org.lab.rm.engine.model.pj.ProfessionRealm;
import org.lab.rm.engine.model.pj.Race;
import org.lab.rm.engine.model.pj.RaceStats;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

public class PjCreationService {

	@Inject
	private RandomService randomService;
	@Inject
	private Datastore datastore;

	public Pj prepare(User user, String name, Race race, Profession profession, ProfessionRealm realm) {
		RaceStats raceStats = datastore.find(RaceStats.class, "race", race.name()).iterator().next();

		Pj pj = new Pj();
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

	public void randomizeAttributes(Pj pj) {
		for (Attribute i : pj.getAttributes().values()) {
			i.setValue(randomService.rand(20, 100));
		}
	}

}
