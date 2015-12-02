package org.lab.rm.engine.test;

import java.util.ArrayList;

import org.junit.Test;
import org.lab.rm.engine.core.actor.ActorEntityService;
import org.lab.rm.engine.core.entities.UserEntityService;
import org.lab.rm.engine.core.guice.RmEngineModule;
import org.lab.rm.engine.core.guice.serialization.Serializer;
import org.lab.rm.engine.model.Actor;
import org.lab.rm.engine.model.ActorAttribute;
import org.lab.rm.engine.model.ActorClass;
import org.lab.rm.engine.model.AttributeType;
import org.lab.rm.engine.model.Gender;
import org.lab.rm.engine.model.Race;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.user.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ActorEntityTest {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new RmEngineModule());

		UserEntityService entityService = injector.getInstance(UserEntityService.class);
		ActorEntityService actorEntityService = injector.getInstance(ActorEntityService.class);
		Serializer serializer = injector.getInstance(Serializer.class);

		User user = entityService.findByName("lab.cabrera");

		Actor actor = new Actor();
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

		Message<Actor> result = actorEntityService.persist(actor);
		System.out.println("Persist result:");
		System.out.println(serializer.toJson(result));

	}

}
