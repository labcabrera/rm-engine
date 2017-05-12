package org.lab.rm.engine.core.table;

import java.util.HashMap;
import java.util.Map.Entry;

import org.lab.rm.engine.model.table.SingleEntryTable;
import org.lab.rm.engine.model.table.repository.SingleEntryTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

	@Autowired
	private SingleEntryTableRepository singleEntryTableRepository;

	public SingleEntryTable getSingleEntryTable(String name) {
		SingleEntryTable table = singleEntryTableRepository.findByName(name);
		if (table == null) {
			return null;
		}
		if (table.getCondensed() != null && table.getCondensed()) {
			SingleEntryTable expanded = new SingleEntryTable();
			expanded.setName(name);
			expanded.setCondensed(false);
			expanded.setValues(new HashMap<>());
			for (Entry<String, String> entry : table.getValues().entrySet()) {
				String key = entry.getKey();
				int index = key.indexOf(':');
				if (index < 0) {
					expanded.getValues().put(key, entry.getValue());
				} else {
					int min = Integer.valueOf(key.substring(0, index));
					int max = Integer.valueOf(key.substring(1 + index));
					for (int i = min; i <= max; i++) {
						expanded.getValues().put(String.valueOf(i), entry.getValue());
					}
				}
			}
			return expanded;
		}
		return table;
	}

	public SingleEntryTable save(SingleEntryTable table) {
		return singleEntryTableRepository.save(table);
	}

}
