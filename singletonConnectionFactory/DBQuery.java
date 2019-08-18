package singletonConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.sql.DataSource;

import com.mysql.jdbc.ResultSetMetaData;

import models.Book;

public class DBQuery {
	DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	HashMap<String, Object> info = new HashMap<>();
	
	public ArrayList<String> queryOne (String query, String param1) {
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
	
	
	
	public Book queryBooks (String query) throws SQLException {
		Book book = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			book = new Book();
			while(rs.next()){
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPublishingHouse(rs.getString("publishing_house"));				
				book.setPublicationDate(rs.getDate("publication_year"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getBigDecimal("price"));
				book.setDescription(rs.getString("description"));
				book.setPoints(rs.getInt("points"));;
				book.setBoughtTimes(rs.getInt("bought_times"));
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
		return book;
	}
	public ArrayList<String> queryAll (String query) throws SQLException {
		ArrayList<String> results = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); 
			int columnCount = rsmd.getColumnCount();
			results = new ArrayList<String>(columnCount);
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

	public DBQuery() {
		// TODO Auto-generated constructor stub
	}

}
