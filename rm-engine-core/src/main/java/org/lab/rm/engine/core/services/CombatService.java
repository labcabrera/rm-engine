package org.lab.rm.engine.core.services;

import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.character.CharacterContext;
import org.lab.rm.engine.model.common.Message;

public interface CombatService {

	Message<Object> prepare(CharacterContext source, CharacterContext target, AttackOptions options);

	Message<Object> execute(CharacterContext source, CharacterContext target, AttackOptions options);

}
