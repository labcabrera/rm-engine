package org.lab.rm.engine.model.services.character.creation;

import org.lab.rm.engine.model.character.PlayerCharacter;
import org.lab.rm.engine.model.character.extension.CharacterExtension;
import org.lab.rm.engine.model.character.extension.CharacterMovementInfo;

public class CharacterMovementInitializer implements CharacterInitializer {

	@Override
	public void initialize(PlayerCharacter character) {
		CharacterMovementInfo info = character.getModule(CharacterExtension.MOVEMENT, CharacterMovementInfo.class);
		// TODO
		info.setCapacidadDeMovimientoBasica(50d);

	}

}
