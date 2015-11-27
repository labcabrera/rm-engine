package org.lab.rm.engine.core.character;

import org.lab.rm.engine.model.CharacterStatus;
import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.common.Message;

public interface AttackManager {

	Message<Object> prepare(CharacterStatus source, CharacterStatus target, AttackOptions options);

	Message<Object> execute(CharacterStatus source, CharacterStatus target, AttackOptions options);

}
