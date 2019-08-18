package singletonConnectionFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.sql.DataSource;

import com.mysql.jdbc.ResultSetMetaData;

import models.Book;

public class DBQuery {
	DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	

	
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
	
	public Book queryBook (String query) throws SQLException {
		Book book = new Book();
		HashMap<String, Object> bookMap = new HashMap<>();
		bookMap = genericQuery(query);
		Class cls = book.getClass();
        // returns the array of Field objects
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
        	fields[i].setAccessible(true);
        	String key = fields[i].getName();
        	
        	if (bookMap.get(key) != null ) {
        		Object value = bookMap.get(key);
            	if (Integer.class.isAssignableFrom(fields[i].getType())) {
            	    value = Integer.valueOf((String) bookMap.get(key));
            	} else {
            		value = (String) bookMap.get(key);
            	}
        		try {
					fields[i].set(book, value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	
        } 
		return book;
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
				book.setPublishing_house(rs.getString("publishing_house"));				
				book.setPublication_year(rs.getString("publication_year"));
				book.setCategory(rs.getString("category"));
				book.setPrice(rs.getInt("price"));
				book.setDescription(rs.getString("description"));
				book.setPoints(rs.getInt("points"));;
				book.setBought_times(rs.getInt("bought_times"));
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
				
				for (int i = 1; i<=columnCount; i++) {
					String value= rs.getString(i);
					results.add(value);
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
	
	public HashMap<String,Object> genericQuery (String query) throws SQLException {
		HashMap<String, Object> info = new HashMap<>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData(); 
			int columnCount = rsmd.getColumnCount();
			while(rs.next()){
				//System.out.println("title="+rs.getString("title")+", author="+rs.getString("author"));
				
				for (int i = 1; i<=columnCount; i++) {
					String value= rs.getString(i);
					info.put(rsmd.getColumnLabel(i), value);
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
		return info;
	}

	public DBQuery() {
		// TODO Auto-generated constructor stub
	}

}
