package uk.co.pocketinventor.util.database.record;

import java.util.HashMap;
import java.util.Set;

public class QueryResults {

	public HashMap<String, QueryRecord> records = new HashMap<String, QueryRecord>();
	
//	public TerineaList getAsOldList(String col) {
//		TerineaList oldList = new TerineaList();
//		Set<String> list = records.keySet();
//		
//		if (!list.isEmpty()) {
//			for (int i = 0; i < list.size(); i++) {
//				String id = (String) list.toArray()[i];
//				QueryRecord record = records.get(id);
//				oldList.addRecord(record.getAsOldRecord(col));
//			}
//			return oldList;
//		} else {
//			System.err.println("Table does not contain record for settings");
//		}
//		return null;
//	}
	
}
