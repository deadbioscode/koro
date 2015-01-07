package uk.co.pocketinventor.util.database.record;

import java.util.HashMap;
import java.util.Map;

public class QueryRecord {

	public String id = null;
	
	public HashMap<String, String> column = new HashMap<String, String>();
	
	public QueryRecord() {
		
	}
	
	public QueryRecord(String id, Map<String, String> data) {
		this.id = id;
		this.column = (HashMap<String, String>) data;
	}
	
	public void addColumn(String columnName, String value) {
		this.column.put(columnName, value);
	}
	
//	public TerineaRecord getAsOldRecord(String col) {
//		TerineaRecord record = new TerineaRecord(id, column.get(col));
//		return record;
//	}
	
	
	
}
