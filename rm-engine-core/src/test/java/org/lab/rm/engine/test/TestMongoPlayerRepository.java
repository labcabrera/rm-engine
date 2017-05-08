package org.lab.rm.engine.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.core.model.player.Player;
import org.lab.rm.engine.core.model.player.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RmEngineCoreConfig.class)
public class TestMongoPlayerRepository {

	@Autowired
	private PlayerRepository playerRepository;

	@Test
	public void test() {
		long count = playerRepository.count();
		System.out.println("Players: " + count);

		Player player = playerRepository.findByName("lab.cabrera");
		Assert.notNull(player, "Player cant be nullº");

	}

}
