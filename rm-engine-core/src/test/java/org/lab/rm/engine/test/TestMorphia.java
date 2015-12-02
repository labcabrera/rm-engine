package org.lab.rm.engine.test;

import java.util.ArrayList;

import javax.inject.Provider;

import org.junit.Test;
import org.lab.rm.engine.core.guice.CoreModule;
import org.lab.rm.engine.model.Campaign;
import org.lab.rm.engine.model.actor.Actor;
import org.lab.rm.engine.model.actor.ActorAttribute;
import org.lab.rm.engine.model.actor.ActorClass;
import org.lab.rm.engine.model.actor.AttributeType;
import org.lab.rm.engine.model.actor.Gender;
import org.lab.rm.engine.model.actor.Race;
import org.lab.rm.engine.model.user.User;
import org.mongodb.morphia.Datastore;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class TestMorphia {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new CoreModule());
		Provider<Datastore> datastoreProvider = injector.getProvider(Datastore.class);

		Datastore datastore = datastoreProvider.get();

		User owner = datastore.find(User.class, "name", "lab.cabrera").iterator().next();

		Actor actor01 = new Actor();
		actor01.setName("Kiove");
		actor01.setOwner(owner);
		actor01.setActorClass(ActorClass.ROGUE);
		actor01.setRace(Race.GREY_ELF);
		actor01.setAge(35);
		actor01.setCurrentLevel(100);
		actor01.setMaxLevel(100);
		actor01.setXp(42384723L);
		actor01.setMaxHitPoints(245);
		actor01.setGender(Gender.FEMALE);
		actor01.setAttributes(new ArrayList<ActorAttribute>());
		actor01.getAttributes().add(new ActorAttribute(AttributeType.REASONING, 92));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.AGILITY, 89));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.CONSTITUTION, 25));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.APPEARANCE, 75));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.INTUITION, 55));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.QUICKNESS, 91));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.SANITY, 32));
		actor01.getAttributes().add(new ActorAttribute(AttributeType.MEMORY, 87));
		datastore.save(actor01);

		Actor actor02 = new Actor();
		actor02.setName("Shiova");
		actor02.setOwner(owner);
		actor02.setRace(Race.MIXED_MAN);
		actor02.setActorClass(ActorClass.MAGICIAN);
		datastore.save(actor02);

		Campaign campaign = new Campaign();
		campaign.setName("Dummy campaign");
		campaign.setOwner(owner);
		campaign.setActors(new ArrayList<Actor>());
		campaign.getActors().add(actor01);
		campaign.getActors().add(actor02);

		datastore.save(campaign);
	}

}
