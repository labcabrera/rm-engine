package com.lab.rm.engine.deploy.feeders;

import org.lab.rm.engine.core.model.player.Player;

import net.sf.flatpack.DataSet;

public class UserFeeder extends CsvFeeder<Player, String> {

	@Override
	protected String getResourceName() {
		return "users.csv";
	}

	@Override
	protected Player parseRow(DataSet dataSet) {
		Player user = new Player();
		user.setName(dataSet.getString("NAME"));
		user.setEmail(dataSet.getString("EMAIL"));
		return user;
	}
}
