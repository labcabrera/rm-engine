package org.lab.rm.engine.test;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;
import org.lab.rm.engine.core.model.RangeTable;
import org.lab.rm.engine.core.model.services.RangeTableService;
import org.springframework.util.Assert;

public class RangeTableTest {

	private RangeTable<Integer> rangeTable;
	private RangeTableService rangeTableService;

	@Before
	public void init() {
		rangeTable = new RangeTable<>();
		rangeTable.setValues(new LinkedHashMap<>());
		rangeTable.getValues().put("1", 1);
		rangeTable.getValues().put("2:5", 2);
		rangeTable.getValues().put("6", 3);
		rangeTable.getValues().put("7:9", 5);
		rangeTable.getValues().put("10", 6);
		rangeTableService = new RangeTableService();
	}

	@Test
	public void test() {
		// TODO hamcrest
		Assert.isTrue(1 == rangeTableService.get(rangeTable, 1), "Error");
		Assert.isTrue(2 == rangeTableService.get(rangeTable, 2), "Error");
		Assert.isTrue(2 == rangeTableService.get(rangeTable, 3), "Error");
		Assert.isTrue(2 == rangeTableService.get(rangeTable, 4), "Error");
		Assert.isTrue(2 == rangeTableService.get(rangeTable, 5), "Error");
		Assert.isTrue(3 == rangeTableService.get(rangeTable, 6), "Error");
		Assert.isTrue(6 == rangeTableService.get(rangeTable, 10), "Error");

	}

}
