package com.lab.rm.engine.deploy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab.rm.engine.deploy.feeders.ArmorFeeder;
import com.lab.rm.engine.deploy.feeders.RaceStatsFeeder;
import com.lab.rm.engine.deploy.feeders.UserFeeder;
import com.lab.rm.engine.deploy.feeders.WeaponFeeder;

@SpringBootApplication
public class Bootstrap implements CommandLineRunner {

	@Autowired
	private UserFeeder userFeeder;
	@Autowired
	private RaceStatsFeeder raceStatsFeeder;
	@Autowired
	private WeaponFeeder weaponFeeder;
	@Autowired
	private ArmorFeeder armorFeeder;

	public static void main(String[] args) {
		SpringApplication.run(Bootstrap.class, args);

	}

	//TODO create feeder annotation and get all items annnotated
	@Override
	public void run(String... args) throws Exception {
		userFeeder.run();
		raceStatsFeeder.run();
		weaponFeeder.run();
		armorFeeder.run();
	}
}
