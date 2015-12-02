package org.lab.rm.engine.core.actor;

import org.lab.rm.engine.model.ActorContext;
import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.common.Message;

public interface AttackManager {

	Message<Object> prepare(ActorContext source, ActorContext target, AttackOptions options);

	Message<Object> execute(ActorContext source, ActorContext target, AttackOptions options);

}
