package com.lab.rm.engine.deploy.feeders;

import java.util.LinkedHashMap;

import org.lab.rm.engine.core.model.character.AttributeType;
import org.lab.rm.engine.core.model.character.Race;
import org.lab.rm.engine.core.model.character.RaceStats;
import org.lab.rm.engine.core.model.character.Resist;

import net.sf.flatpack.DataSet;

public class RaceStatsFeeder extends CsvFeeder<RaceStats, String> {

	@Override
	protected String getResourceName() {
		return "race-stats.csv";
	}

	@Override
	protected RaceStats parseRow(DataSet dataSet) {
		RaceStats entity = new RaceStats();
		entity.setRace(Race.valueOf(dataSet.getString("RACE")));
		entity.setAttributes(new LinkedHashMap<AttributeType, Integer>());
		for (AttributeType i : AttributeType.values()) {
			entity.getAttributes().put(i, dataSet.getInt(i.name()));
		}
		entity.setResist(new LinkedHashMap<Resist, Integer>());
		for (Resist i : Resist.values()) {
			entity.getResist().put(i, dataSet.getInt("RES_" + i.name()));
		}
		return entity;
	}

}
