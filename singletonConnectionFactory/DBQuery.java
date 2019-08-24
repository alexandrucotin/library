package singletonConnectionFactory;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import com.mysql.jdbc.ResultSetMetaData;

import models.Book;
import models.Order;
import models.User;

public class DBQuery {
	DataSource ds = MyDataSourceFactory.getMySQLDataSource();
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;

	public ArrayList<String> queryOne(String query, String param1) {
		ArrayList<String> results = new ArrayList<String>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				// System.out.println("title="+rs.getString("title")+",
				// author="+rs.getString("author"));
				String someValue = rs.getString(param1);
				results.add(someValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

	public Book queryBook(String query) throws SQLException {
		Book book = new Book();
		HashMap<String, Object> bookMap = new HashMap<>();
		bookMap = genericQuery(query).get(0);
		Class cls = book.getClass();
		// returns the array of Field objects
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String key = fields[i].getName();

			if (bookMap.get(key) != null) {
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

	public Order queryOrder(String query) throws SQLException {
		Order order = new Order();
		HashMap<String, Object> orderMap = new HashMap<>();
		orderMap = genericQuery(query).get(0);
		Class cls = order.getClass();
		// returns the array of Field objects
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String key = fields[i].getName();

			if (orderMap.get(key) != null) {
				Object value = orderMap.get(key);
				if (Integer.class.isAssignableFrom(fields[i].getType())) {
					value = Integer.valueOf((String) orderMap.get(key));
				} else {
					value = (String) orderMap.get(key);
				}
				try {
					fields[i].set(order, value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return order;
	}

	public void queryRegister(String query) {
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean checkLogin(String query, String userid, String email, String password, String role) throws SQLException {
		boolean userExist = false;
		boolean loggedInAlready = false;
		
		loggedInAlready = statusUser(userid, email, "statususers");
		if (loggedInAlready) {
			userExist = true;
			return userExist;
		} else {
			try {
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				while (rs.next()) {
					// System.out.println("title="+rs.getString("title")+",
					// author="+rs.getString("author"));
					String iduserDB = rs.getString("iduser");
					String emailDB = rs.getString("email");
					String passwordDB = rs.getString("password");

					if (userid.equals(iduserDB) && email.equals(emailDB) && password.equals(passwordDB)) {
						userExist = true;
					}
				}
				if (userExist) {
					stmt.execute("TRUNCATE TABLE statususers");
					stmt.executeUpdate("INSERT INTO statususers " + "VALUES (true,"+ "'" + userid + "'," + "'" + email + "'," + "'" + role + "')");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null) 
						stmt.close();
					if (con != null)
						con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return userExist;
		}

	}

	public boolean statusUser(String userid, String email, String db) throws SQLException {
		boolean status = false;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from " + db + ";");
			while (rs.next()) {
				// System.out.println("title="+rs.getString("title")+",
				// author="+rs.getString("author"));
				String iduserDB = rs.getString("iduser");
				String emailDB = rs.getString("email");
				if (userid.equals(iduserDB) && email.equals(emailDB)) {
					status = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}

	public User queryUser(String query) throws SQLException {
		User user = new User();
		HashMap<String, Object> userMap = new HashMap<>();
		userMap = genericQuery(query).get(0);
		Class cls = user.getClass();
		// returns the array of Field objects
		Field[] fields = cls.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			fields[i].setAccessible(true);
			String key = fields[i].getName();

			if (userMap.get(key) != null) {
				Object value = userMap.get(key);
				if (Integer.class.isAssignableFrom(fields[i].getType())) {
					value = Integer.valueOf((String) userMap.get(key));
				} else {
					value = (String) userMap.get(key);
				}
				try {
					fields[i].set(user, value);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
		return user;
	}

	public List<Book> queryBooks(String query) throws SQLException {
		List<Book> topBooks = new ArrayList<>();
		List<HashMap<String, Object>> bookList = genericQuery(query);
		for (HashMap<String, Object> element : bookList) {
			Book book = new Book();
			Class cls = book.getClass();
			// returns the array of Field objects
			Field[] fields = cls.getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);
				String key = fields[i].getName();

				if (element.get(key) != null) {
					Object value = element.get(key);
					if (Integer.class.isAssignableFrom(fields[i].getType())) {
						value = Integer.valueOf((String) element.get(key));
					} else {
						value = (String) element.get(key);
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
			topBooks.add(book);
		}
		return topBooks;
	}

	public ArrayList<String> queryAll(String query) throws SQLException {
		ArrayList<String> results = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			results = new ArrayList<String>(columnCount);
			while (rs.next()) {
				// System.out.println("title="+rs.getString("title")+",
				// author="+rs.getString("author"));

				for (int i = 1; i <= columnCount; i++) {
					String value = rs.getString(i);
					results.add(value);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return results;
	}

	public List<HashMap<String, Object>> genericQuery(String query) throws SQLException {
		List<HashMap<String, Object>> infoList = new ArrayList<>();
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				// System.out.println("title="+rs.getString("title")+",
				// author="+rs.getString("author"));
				HashMap<String, Object> element = new HashMap<>();
				for (int i = 1; i <= columnCount; i++) {
					String value = rs.getString(i);
					element.put(rsmd.getColumnLabel(i), value);
				}
				infoList.add(element);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return infoList;
	}

	public DBQuery() {
		// TODO Auto-generated constructor stub
	}

}
