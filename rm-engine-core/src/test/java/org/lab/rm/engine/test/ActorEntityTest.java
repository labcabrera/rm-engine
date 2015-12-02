package org.lab.rm.engine.test;

import org.junit.Test;
import org.lab.rm.engine.core.actor.ActorEntityService;
import org.lab.rm.engine.core.entities.UserEntityService;
import org.lab.rm.engine.core.guice.RmEngineModule;
import org.lab.rm.engine.model.Actor;
import org.lab.rm.engine.model.ActorAttributes;
import org.lab.rm.engine.model.ActorClass;
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

		User user = entityService.findByName("lab.cabrera");
		user.setName("labcabrera");
		user.setEmail("lab.cabrera@gmail.com");

		Actor actor = new Actor();
		actor.setName("Kiove");
		actor.setActorClass(ActorClass.ROGUE);
		actor.setRace(Race.GREY_ELF);
		actor.setAge(35);
		actor.setCurrentLevel(100);
		actor.setMaxLevel(100);
		actor.setXp(42384723L);
		actor.setGender(Gender.FEMALE);
		actor.setAttributes(new ActorAttributes());
		actor.getAttributes().setReasoning(98);
		actor.getAttributes().setAgility(94);
		actor.getAttributes().setConstitution(25);
		actor.getAttributes().setAppearance(75);
		actor.getAttributes().setIntuition(55);
		actor.getAttributes().setQuickness(91);
		actor.getAttributes().setSanity(23);
		actor.getAttributes().setMemory(78);
		actor.getAttributes().setMaxHitPoints(456);

		Message<Actor> result = actorEntityService.persist(actor);
		System.out.println(result);
	}

}
