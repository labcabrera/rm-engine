package org.lab.rm.engine.core.services;

import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.common.Message;
import org.lab.rm.engine.model.pj.PjContext;

public interface CombatService {

	Message<Object> prepare(PjContext source, PjContext target, AttackOptions options);

	Message<Object> execute(PjContext source, PjContext target, AttackOptions options);

}
