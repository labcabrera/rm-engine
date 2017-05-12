package org.lab.rm.engine.core.test;

import java.util.HashMap;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lab.rm.engine.core.config.RmEngineCoreConfig;
import org.lab.rm.engine.core.table.TableService;
import org.lab.rm.engine.model.table.SingleEntryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RmEngineCoreConfig.class)
public class TableServiceTest {

	@Autowired
	private TableService tableService;

	@Test
	public void test_basic() {
		SingleEntryTable table = tableService.getSingleEntryTable("dummy.basic");
		if (table == null) {
			table = new SingleEntryTable();
			table.setName("dummy.basic");
			table.setValues(new HashMap<>());
			table.getValues().put("42", "10");
			table = tableService.save(table);
		}
		table = tableService.getSingleEntryTable("dummy.basic");
		MatcherAssert.assertThat("10", Matchers.is(table.get("42")));
	}

	@Test
	public void test_condensed() {
		SingleEntryTable table = tableService.getSingleEntryTable("dummy.condensed");
		if (table == null) {
			table = new SingleEntryTable();
			table.setName("dummy.condensed");
			table.setCondensed(true);
			table.setValues(new HashMap<>());
			table.getValues().put("1", "1");
			table.getValues().put("2:5", "2");
			table.getValues().put("6", "3");
			table = tableService.save(table);
		}
		table = tableService.getSingleEntryTable("dummy.condensed");
		MatcherAssert.assertThat("1", Matchers.is(table.get("1")));
		MatcherAssert.assertThat("2", Matchers.is(table.get("2")));
		MatcherAssert.assertThat("2", Matchers.is(table.get("3")));
		MatcherAssert.assertThat("2", Matchers.is(table.get("4")));
		MatcherAssert.assertThat("2", Matchers.is(table.get("5")));
		MatcherAssert.assertThat("3", Matchers.is(table.get("6")));
	}

}
