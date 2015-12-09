package org.lab.rm.engine.model.character;

public enum Profession {

	/** Guerrero */
	FIGHTER(ProfessionRealm.ARMS),

	/** Ladron */
	THIEF(ProfessionRealm.ARMS),

	/** Bribon */
	ROGUE(ProfessionRealm.ARMS),

	/** Monje guerrero */
	WARRIOR_MONK(ProfessionRealm.ARMS),

	/** Mago */
	MAGE(ProfessionRealm.ESSENCE),

	/** Ilusionista */
	ILUSIONISTA(ProfessionRealm.ESSENCE),

	ALQUIMISTA((ProfessionRealm.ESSENCE)),

	/** Clérigo */
	CLERIC(ProfessionRealm.CHANNELING),

	/** Animista */
	DRUID(ProfessionRealm.CHANNELING),

	/** Sanador */
	HEALER(ProfessionRealm.CHANNELING),

	/** Mentalista */
	MENTALIST(ProfessionRealm.MENTALISM),

	/** Curandero */
	LAY_HEALER(ProfessionRealm.MENTALISM),

	/** Vidente */
	SEER(ProfessionRealm.ARMS),

	/** Brujo */
	LOCK(ProfessionRealm.ESSENCE, ProfessionRealm.CHANNELING),

	MISTICO(ProfessionRealm.ESSENCE, ProfessionRealm.ESSENCIA_MENTALISMO),

	ASTROLOGO(ProfessionRealm.CHANNELING, ProfessionRealm.MENTALISM),

	MONJE(ProfessionRealm.ARMS_MAGIC),

	GUARDABOSQUES(ProfessionRealm.ARMS_MAGIC),

	BARDO(ProfessionRealm.ARMS_MAGIC);

	// PALADIN,
	//
	// ARMSMASTER,
	//
	// ARCANIST

	private ProfessionRealm[] realms;

	private Profession(ProfessionRealm... realm) {
		this.realms = realms;
	}

	public ProfessionRealm[] getRealms() {
		return realms;
	}
}
