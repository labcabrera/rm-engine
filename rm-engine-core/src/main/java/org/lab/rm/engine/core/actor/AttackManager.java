package org.lab.rm.engine.core.actor;

import org.lab.rm.engine.model.ActorStatus;
import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.common.Message;

public interface AttackManager {

	Message<Object> prepare(ActorStatus source, ActorStatus target, AttackOptions options);

	Message<Object> execute(ActorStatus source, ActorStatus target, AttackOptions options);

}
