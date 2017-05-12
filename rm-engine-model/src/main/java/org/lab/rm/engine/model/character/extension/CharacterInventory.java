package org.lab.rm.engine.model.character.extension;

import org.lab.rm.engine.model.character.Inventory;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterInventory implements CharacterExtension {

	private Inventory inventory;

	@Override
	public String name() {
		return CharacterExtension.INVENTORY;
	}

}
