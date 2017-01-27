package org.rscarela.tibia.api.worlds;

/**
 * An enum containing all game worlds.
 *
 * @author Renan Scarela
 */
public enum WorldName {

	AMERA,
	ANTICA,
	ASTERA,
	AURERA,
	AURORA,
	BELLONA,
	BENEVA,
	CALMERA,
	CALVA,
	CALVERA,
	CANDIA,
	CELESTA,
	CHRONA,
	DANERA,
	DOLERA,
	EFIDIA,
	ELDERA,
	FIDERA,
	FORTERA,
	GARNERA,
	GUARDIA,
	HARMONIA,
	HONERA,
	HYDERA,
	INFERNA,
	IONA,
	IRMADA,
	JULERA,
	JUSTERA,
	KENORA,
	KRONERA,
	LAUDERA,
	LUMINERA,
	MAGERA,
	MENERA,
	MORTA,
	MORTERA,
	NEPTERA,
	NERANA,
	NIKA,
	OLYMPA,
	OSERA,
	PACERA,
	PREMIA,
	PYTHERA,
	QUILIA,
	REFUGIA,
	ROWANA,
	SECURA,
	SHIVERA,
	SILVERA,
	SOLERA,
	THERA,
	UMERA,
	UNITERA,
	VELUDERA,
	XANTERA,
	XYLANA,
	YANARA,
	ZANERA,
	ZELUNA,
	FEROBRA,
	SERDEBRA,
	VERLANA;

	public String getFormattedName() {
		return name().substring(0, 1) + name().substring(1).toLowerCase();
	}

}
