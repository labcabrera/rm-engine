package org.lab.rm.engine.core.model.services.character.creation;

import org.lab.rm.engine.core.model.character.PlayerCharacter;

public class CharacterMovementInitializer implements CharacterInitializer {

	@Override
	public void initialize(PlayerCharacter character) {
		// TODO
		character.getMovementInfo().setCapacidadDeMovimientoBasica(50d);

	}

}
