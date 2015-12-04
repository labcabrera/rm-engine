package org.lab.rm.engine.core.pj;

import java.util.LinkedHashMap;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.lab.rm.engine.core.common.RandomService;
import org.lab.rm.engine.model.pj.AttributeType;
import org.lab.rm.engine.model.pj.PJAttribute;
import org.lab.rm.engine.model.pj.Pj;
import org.lab.rm.engine.model.pj.Profession;
import org.lab.rm.engine.model.pj.ProfessionRealm;
import org.lab.rm.engine.model.pj.Race;
import org.lab.rm.engine.model.user.User;

public class PjCreationService {

	@Inject
	private RandomService randomService;

	public Pj prepare(User user, String name, Race race, Profession profession, ProfessionRealm realm) {
		Pj pj = new Pj();
		pj.setOwner(user);
		pj.setName(name);
		pj.setRace(race);
		pj.setProfession(profession);
		pj.setRealm(realm);
		randomizeAttributes(pj);
		return pj;
	}

	public void randomizeAttributes(Pj pj) {
		Validate.notNull(pj.getProfession());
		Validate.notNull(pj.getRace());
		pj.setAttributes(new LinkedHashMap<AttributeType, PJAttribute>());
		for (AttributeType i : AttributeType.values()) {
			PJAttribute a = new PJAttribute();
			a.setValue(randomService.rand(20, 100));
			pj.getAttributes().put(i, a);
		}
	}

}
