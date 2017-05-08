package org.lab.rm.engine.core.model.character;

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

	// TODO required i18n
	MISTICO(ProfessionRealm.ESSENCE, ProfessionRealm.ESSENCIA_MENTALISMO),

	// TODO required i18n
	ASTROLOGO(ProfessionRealm.CHANNELING, ProfessionRealm.MENTALISM),

	// TODO required i18n
	MONJE(ProfessionRealm.ARMS_MAGIC),

	// TODO required i18n
	GUARDABOSQUES(ProfessionRealm.ARMS_MAGIC),

	// TODO required i18n
	BARDO(ProfessionRealm.ARMS_MAGIC);

	// PALADIN,
	//
	// ARMSMASTER,
	//
	// ARCANIST

	private ProfessionRealm[] realms;

	private Profession(ProfessionRealm... realms) {
		this.realms = realms;
	}

	public ProfessionRealm[] getRealms() {
		return realms;
	}
}
