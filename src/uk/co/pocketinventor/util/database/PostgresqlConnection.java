package uk.co.pocketinventor.util.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uk.co.pocketinventor.util.database.record.QueryRecord;
import uk.co.pocketinventor.util.database.record.QueryResults;

public class PostgresqlConnection {

	/**
	 * Serial ID
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	
	public PostgresqlConnection(String dbLocation, String dbUsername, String dbPassword) throws SQLException {
		try {
			System.out.println("Connecting to: " + dbLocation);
			conn = DriverManager.getConnection("jdbc:postgresql://"+ dbLocation, dbUsername, dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to connect to database");
			throw e;
		}
	}
	
	public QueryResults runGetQuery(String query, String id, String... data) {
		ResultSet rs = null;
		QueryResults result = new QueryResults();
		try {
			PreparedStatement st = conn.prepareStatement(query);
			rs = st.executeQuery();
			
			while(rs.next()) {
				QueryRecord record = new QueryRecord();
				record.id = rs.getString(id);
				for (String d : data) {
					record.addColumn(d, rs.getString(d));
				}
				result.records.put(record.id, record);
			}
			if (result.records.size() < 1) return null;
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Failed to run query");
			return null;
		}
	}
	
	public QueryResults runSelectQuery(String table, String id, String...strings) {
		
		String query = "SELECT ";
		for (String col : strings) {
			query += col + ", ";
		}
		query += id + " FROM " + table;
		
		System.out.println(query);
		
		return runGetQuery(query, id, strings);
	}
	
	public QueryResults runSelectQueryWhere(String table, String id, String conditions, String...strings) {
		
		String query = "SELECT ";
		for (String col : strings) {
			query += col + ", ";
		}
		query += id + " FROM " + table + " " + conditions;
		
		System.out.println(query);
		
		return runGetQuery(query, id, strings);
	}
	
	public boolean runPutQuery(String query) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(query);
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to run query");
			return false;
		} finally {
//			try {
//				st.close();
//			} catch (SQLException e) {
//				if (Launcher.devmode) e.printStackTrace();
//				System.err.println("Failed to close prepared statement");
//			}
		}
	}
	
	public boolean runInsertQuery(String query) {
		return runPutQuery(query);
	}
	
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Failed to close connection");
		}
	}
}
