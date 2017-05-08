package org.lab.rm.engine.core.model.character;

import org.lab.rm.engine.core.model.combat.AttackBonus;
import org.lab.rm.engine.core.model.combat.DefenseBonus;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Reference;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
public class CharacterContext {

	@Id
	private String id;

	@Reference
	private PlayerCharacter pj;

	private Inventory inventory;

	private DefenseBonus defenseBonus;

	private AttackBonus offenseBonus;

	private Integer currentHitPoints;

	public CharacterContext(PlayerCharacter pj) {
	}

}
