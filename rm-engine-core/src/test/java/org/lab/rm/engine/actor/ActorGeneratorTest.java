package org.lab.rm.engine.actor;

import org.junit.Test;
import org.lab.rm.engine.core.actor.ActorEntityService;
import org.lab.rm.engine.core.guice.RmEngineModule;
import org.lab.rm.engine.model.Actor;
import org.lab.rm.engine.model.ActorAttributes;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.common.User;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class ActorGeneratorTest {

	@Test
	public void test() {
		Injector injector = Guice.createInjector(new RmEngineModule());
		
		ActorEntityService actorEntityService = injector.getInstance(ActorEntityService.class);

		User user = new User();
		user.setName("labcabrera");
		user.setEmail("lab.cabrera@gmail.com");

		Actor actor = new Actor();
		actor.setName("Kiove");
		actor.setAttributes(new ActorAttributes());
		actor.getAttributes().setReasoning(98);

		Message<Actor> result = actorEntityService.persist(actor);
		System.out.println(result);
	}

}
