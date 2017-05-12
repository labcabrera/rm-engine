package org.lab.rm.engine.core.services.movement;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.model.movement.ManeuverDifficulty;
import org.lab.rm.engine.model.movement.MovementManeuverResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RmEngineCoreConfig.class)
public class MovementManeuverServiceTest {

	@Autowired
	private MovementManeuverService service;

	@Test
	public void test() {
		MovementManeuverResult r01 = service.find(60, ManeuverDifficulty.RUTINA);
		MatcherAssert.assertThat(r01, Matchers.notNullValue());
		MatcherAssert.assertThat(r01.getPercent(), Matchers.is(100));
	}
}
