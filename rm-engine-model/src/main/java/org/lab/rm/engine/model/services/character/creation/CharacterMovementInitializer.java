package org.lab.rm.engine.model.services.character.creation;

import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.extension.CharacterExtension;
import org.lab.rm.engine.model.character.extension.CharacterMovement;

public class CharacterMovementInitializer implements CharacterInitializer {

	@Override
	public void initialize(PlayerCharacter character) {
		CharacterMovement info = character.getModule(CharacterExtension.MOVEMENT, CharacterMovement.class);
		// TODO
		info.setCapacidadDeMovimientoBasica(50d);

	}

}
