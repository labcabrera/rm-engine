package org.lab.rm.engine.model.character;

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

	DESARROLLO_CORPORAL(SkillCategory.SPECIAL),

	ACROBACIA(SkillCategory.SECONDARY),

	ACTUAR(SkillCategory.SECONDARY),

	AGILIDAD_MANUAL(SkillCategory.SECONDARY),

	ASTRONOMIA(SkillCategory.SECONDARY),

	BAILE(SkillCategory.SECONDARY),

	CAIDAS(SkillCategory.SECONDARY),

	CANTO(SkillCategory.SECONDARY),

	COCINA(SkillCategory.SECONDARY),

	COMERCIO(SkillCategory.SECONDARY),

	CONSTRUCCION_TRAMPAS(SkillCategory.SECONDARY),

	CONTORSIONISMO(SkillCategory.SECONDARY),

	CUEVAS(SkillCategory.SECONDARY),

	CURTICION(SkillCategory.SECONDARY),

	DOMINIO_HECHIZOS(SkillCategory.SECONDARY),

	ESCULPIR_MADERA(SkillCategory.SECONDARY),

	ESCULPIR_PIEDRA(SkillCategory.SECONDARY),

	ESQUI(SkillCategory.SECONDARY),

	FABRICAR_FLECHAS(SkillCategory.SECONDARY),

	FALSIFICACION(SkillCategory.SECONDARY),

	FORRAJEO(SkillCategory.SECONDARY),

	FRENESI(SkillCategory.SECONDARY),

	HABLAR_EN_PUBLICO(SkillCategory.SECONDARY),

	HERRERIA(SkillCategory.SECONDARY),

	INMOVILIZACION(SkillCategory.SECONDARY),

	JUEGO(SkillCategory.SECONDARY),

	MANEJO_CUERDAS(SkillCategory.SECONDARY),

	MATEMATICAS(SkillCategory.SECONDARY),

	MEDITACION(SkillCategory.SECONDARY),

	MUSICA(SkillCategory.SECONDARY),

	NAVEGACION(SkillCategory.SECONDARY),

	PASTOREO(SkillCategory.SECONDARY),

	PRIMEROS_AUXILIOS(SkillCategory.SECONDARY),

	PRONOSTICO_TIEMPO(SkillCategory.SECONDARY),

	REMO(SkillCategory.SECONDARY),

	SEDUCCION(SkillCategory.SECONDARY),

	SEGUIR_RASTROS(SkillCategory.SECONDARY),

	SEÑALES(SkillCategory.SECONDARY),

	VELA(SkillCategory.SECONDARY),

	VETERINARIA(SkillCategory.SECONDARY),

	ZAMBULLIDA(SkillCategory.SECONDARY);

	private SkillCategory category;

	private Skill(SkillCategory category) {
		this.category = category;
	}

	public SkillCategory getCategory() {
		return category;
	}
}
