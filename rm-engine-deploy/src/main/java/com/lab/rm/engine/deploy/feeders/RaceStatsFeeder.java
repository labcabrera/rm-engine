package com.lab.rm.engine.deploy.feeders;

import org.lab.rm.engine.model.pj.Race;
import org.lab.rm.engine.model.pj.RaceStats;

import net.sf.flatpack.DataSet;

public class RaceStatsFeeder extends CsvFeeder<RaceStats> {

	@Override
	protected String getResourceName() {
		return "race-stats.csv";
	}

	@Override
	protected RaceStats parseRow(DataSet dataSet) {
		Race race = Race.valueOf(dataSet.getString("RACE"));

		return null;
	}

}
