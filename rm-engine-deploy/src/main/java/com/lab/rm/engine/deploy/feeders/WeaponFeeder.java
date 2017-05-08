package com.lab.rm.engine.deploy.feeders;

import org.lab.rm.engine.core.model.items.WeaponType;

import net.sf.flatpack.DataSet;

public class WeaponFeeder extends CsvFeeder<WeaponType, String> {

	@Override
	protected String getResourceName() {
		return "weapons.csv";
	}

	@Override
	protected WeaponType parseRow(DataSet dataSet) {
		WeaponType entity = new WeaponType();
		entity.setName(dataSet.getString("NAME"));
		return entity;
	}

}
