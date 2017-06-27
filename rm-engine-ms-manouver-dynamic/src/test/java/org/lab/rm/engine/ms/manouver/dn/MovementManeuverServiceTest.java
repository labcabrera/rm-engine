package org.lab.rm.engine.ms.manouver.dn;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.model.maneuver.DynamicManeuverResult;
import org.lab.rm.engine.model.maneuver.ManeuverDifficulty;
import org.lab.rm.engine.ms.manouver.dn.services.DynamicManeuverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore("Mongo required")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RmEngineCoreConfig.class)
public class MovementManeuverServiceTest {

	@Autowired
	private DynamicManeuverService service;

	@Test
	public void test() {
		DynamicManeuverResult r01 = service.find(60, ManeuverDifficulty.RUTINA);
		MatcherAssert.assertThat(r01, Matchers.notNullValue());
		MatcherAssert.assertThat(r01.getPercent(), Matchers.is(100));
	}
}
