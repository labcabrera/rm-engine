package org.lab.rm.engine.core.services;

import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.actor.ActorContext;
import org.lab.rm.engine.model.common.Message;

public interface CombatService {

	Message<Object> prepare(ActorContext source, ActorContext target, AttackOptions options);

	Message<Object> execute(ActorContext source, ActorContext target, AttackOptions options);

}
