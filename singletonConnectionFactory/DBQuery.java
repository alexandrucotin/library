package singletonConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import javax.sql.DataSource;

import com.mysql.jdbc.ResultSetMetaData;

public class DBQuery {
	
	public ArrayList<String> QueryOne (String query, String param1) {
		DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> results = new ArrayList<String>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				//System.out.println("title="+rs.getString("title")+", author="+rs.getString("author"));
				String someValue = rs.getString(param1);
				results.add(someValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return results;
	}
	public ArrayList<String> QueryAll (String query) throws SQLException {
		DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); 
		int columnCount = rsmd.getColumnCount();
		ArrayList<String> results = new ArrayList<String>(columnCount);
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				//System.out.println("title="+rs.getString("title")+", author="+rs.getString("author"));
				int i = 1;
				   while(i <= columnCount) {
					   results.add(rs.getString(i++));
				   }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return results;
	}
	
	
	public ArrayList<String> QueryTwo (String query, String param1, String param2) {
		DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> results = new ArrayList<String>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()){
				String someValue = rs.getString(param1) + " " + rs.getString(param2);
				results.add(someValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
		return results;
	}

	public DBQuery() {
		// TODO Auto-generated constructor stub
	}

}
