package org.lab.rm.engine.test;

import java.util.ArrayList;

import javax.inject.Provider;

import org.junit.Test;
import org.lab.rm.engine.core.guice.RmEngineModule;
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
		Injector injector = Guice.createInjector(new RmEngineModule());
		Provider<Datastore> datastoreProvider = injector.getProvider(Datastore.class);

		// final Morphia morphia = new Morphia();
		//
		// morphia.mapPackage("org.lab.rm.engine.model");
		//
		// final Datastore datastore = morphia.createDatastore(new MongoClient(), "rm-engine");
		// datastore.ensureIndexes();

		Datastore datastore = datastoreProvider.get();

		User user = new User();
		user.setName("lab.cabrera");
		user.setEmail("lab.cabrera@gmail.com");

		datastore.save(user);
		System.out.println(user.getId());

		Actor actor = new Actor();
		actor.setName("Kiove");
		actor.setOwner(user);
		actor.setName("Kiove");
		actor.setActorClass(ActorClass.ROGUE);
		actor.setRace(Race.GREY_ELF);
		actor.setAge(35);
		actor.setCurrentLevel(100);
		actor.setMaxLevel(100);
		actor.setXp(42384723L);
		actor.setMaxHitPoints(245);
		actor.setGender(Gender.FEMALE);
		actor.setAttributes(new ArrayList<ActorAttribute>());
		actor.getAttributes().add(new ActorAttribute(AttributeType.REASONING, 92));
		actor.getAttributes().add(new ActorAttribute(AttributeType.AGILITY, 89));
		actor.getAttributes().add(new ActorAttribute(AttributeType.CONSTITUTION, 25));
		actor.getAttributes().add(new ActorAttribute(AttributeType.APPEARANCE, 75));
		actor.getAttributes().add(new ActorAttribute(AttributeType.INTUITION, 55));
		actor.getAttributes().add(new ActorAttribute(AttributeType.QUICKNESS, 91));
		actor.getAttributes().add(new ActorAttribute(AttributeType.SANITY, 32));
		actor.getAttributes().add(new ActorAttribute(AttributeType.MEMORY, 87));

		datastore.save(actor);

		System.out.println(actor.getId());
	}

}
