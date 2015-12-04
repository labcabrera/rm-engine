package org.lab.rm.engine.model.pj;

public enum Skill {

	ARMA_FILO_1M(SkillCategory.ARMS),

	ARMA_CONTUNDENTE_1M(SkillCategory.ARMS),

	ARMA_2M(SkillCategory.ARMS),

	ARMA_ARCO(SkillCategory.ARMS),

	ARMA_ARROJADIZA(SkillCategory.ARMS),

	ARMA_ASTA(SkillCategory.ARMS),

	TREPAR(SkillCategory.GENERAL),

	NADAR(SkillCategory.GENERAL),

	MONTAR_ANIMALES(SkillCategory.GENERAL),

	DESACTIVAR_TRAMPAS(SkillCategory.GENERAL),

	FORZAR_CERRADURAS(SkillCategory.GENERAL),

	ACECHAR(SkillCategory.GENERAL),

	OCULTARSE(SkillCategory.GENERAL),

	PERCEPCION(SkillCategory.GENERAL),

	RUNAS(SkillCategory.MAGIC),

	USAR_VARITAS(SkillCategory.MAGIC),

	USAR_BASTONES(SkillCategory.MAGIC),

	HECHIZOS_DIRIGIDOS(SkillCategory.MAGIC),

	LINGUISTICA(SkillCategory.SPECIAL),

	MOVIMIENTOS_ADRENALES(SkillCategory.SPECIAL),

	EMBOSCADA(SkillCategory.SPECIAL),

	DEFENSA_ADRENAL(SkillCategory.SPECIAL),

	ARTES_MARCIALES(SkillCategory.SPECIAL),

	DESARROLLO_CORPORAL(SkillCategory.SPECIAL);

	private SkillCategory category;

	private Skill(SkillCategory category) {
		this.category = category;
	}

	public SkillCategory getCategory() {
		return category;
	}
}
