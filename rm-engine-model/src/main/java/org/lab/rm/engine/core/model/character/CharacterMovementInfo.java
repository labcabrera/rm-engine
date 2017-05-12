package org.lab.rm.engine.core.model.character;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "La capacidad de movimiento de un personaje en un asalto viene dada por su "
		+ "capacidad de movimiento basica, el ritmo de avance y posiblemente una tirada de maniobra")
public class CharacterMovementInfo {

	private Double rapidez;

	@ApiModelProperty(value = "Capacidad de movimiento = (capacidad de movimiento basica) * "
			+ "(multiplicadorDeRitmo) * (resultado de una tirada de maniobra / 100)")
	private Double capacidadDeMovimiento;

	private Double capacidadDeMovimientoBasica;

}
