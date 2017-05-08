package org.lab.rm.engine.core.model.services;

import org.lab.rm.engine.core.model.actions.AttackOptions;
import org.lab.rm.engine.core.model.character.CharacterContext;
import org.lab.rm.engine.core.model.common.Message;

public interface CombatService {

	Message<Object> prepare(CharacterContext source, CharacterContext target, AttackOptions options);

	Message<Object> execute(CharacterContext source, CharacterContext target, AttackOptions options);

}
