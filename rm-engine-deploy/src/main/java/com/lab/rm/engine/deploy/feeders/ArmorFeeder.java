package com.lab.rm.engine.deploy.feeders;

import org.lab.rm.engine.core.model.items.ArmorType;

import net.sf.flatpack.DataSet;

public class ArmorFeeder extends CsvFeeder<ArmorType, String> {

	@Override
	protected String getResourceName() {
		return "armor-types.csv";
	}

	@Override
	protected ArmorType parseRow(DataSet dataSet) {
		ArmorType entity = new ArmorType();
		entity.setCode(dataSet.getString("CODE"));
		entity.setDescription(dataSet.getString("DESC"));
		return entity;
	}

}
