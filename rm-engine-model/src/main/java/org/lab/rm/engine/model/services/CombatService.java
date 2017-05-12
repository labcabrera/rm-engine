package org.lab.rm.engine.model.services;

import org.lab.rm.engine.model.actions.AttackOptions;
import org.lab.rm.engine.model.character.extension.CharacterInventory;
import org.lab.rm.engine.model.common.Message;

public interface CombatService {

	Message<Object> prepare(CharacterInventory source, CharacterInventory target, AttackOptions options);

	Message<Object> execute(CharacterInventory source, CharacterInventory target, AttackOptions options);

}
