package com.lab.rm.engine.deploy.feeders;

import org.apache.commons.codec.digest.DigestUtils;
import org.lab.rm.engine.model.user.User;

import net.sf.flatpack.DataSet;

public class UserFeeder extends CsvFeeder<User> {

	@Override
	protected String getResourceName() {
		return "users.csv";
	}

	@Override
	protected User parseRow(DataSet dataSet) {
		User user = new User();
		user.setName(dataSet.getString("NAME"));
		user.setEmail(dataSet.getString("EMAIL"));
		user.setPasswordDigest(DigestUtils.sha256Hex(dataSet.getString("PASSWORD")));
		return user;
	}
}
