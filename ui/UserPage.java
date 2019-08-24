package ui;


import java.awt.Dimension;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.User;
import singletonConnectionFactory.DBQuery;

public class UserPage extends JPanel {
	private String[][] data;
	private String[] columnNames = {"Name", "Last Name", "Address #1", "Address #2", "CAP", "City", "Phone Number", "Email", "Book card"};
	private JTable table; 
	DefaultTableModel model;
	private User userInfo = new User ();
	
	public User userQuery (String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		userInfo = infoBook.queryUser(query);
		return userInfo;
	}
	
	public void initializeTable() {

		this.data = new String[0][columnNames.length];
		this.table = new JTable(data, columnNames); 
		this.table.setFillsViewportHeight(true);
		this.table.setPreferredScrollableViewportSize(new Dimension(600,50));
		this.model = new DefaultTableModel(columnNames,0);
		this.table.setRowHeight(50);
        JScrollPane sp = new JScrollPane(this.table); 
        add(sp);
        model.addRow(new String[columnNames.length]);
        this.table.setModel(model);
	}
	
	public void userPanel(String iduser) {
		try {
			userQuery("select name, last_name, address, address_2, cap, city, phone_number, email, bookcard_id from user where iduser='" + iduser +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {     

	         Class cls = userInfo.getClass();
	         // returns the array of Field objects
	         Field[] fields = cls.getDeclaredFields();
		     data = new String[1][columnNames.length];

		 	int selectedField = 0;
	         for(int i = 0; i < fields.length; i++) {
	        	fields[i].setAccessible(true);
	        	
	            Object value = fields[i].get(userInfo);
	            if (value != null) {
			        //System.out.println(value);
		            data[0][selectedField] = value.toString();
		            model.setValueAt(value.toString(), 0, selectedField);
		            selectedField++;
	            }
	         }
	      } catch(Exception e) {
	         System.out.println(e.toString());
	      }
	}
	
	public UserPage() {
		initializeTable();
		userPanel("ID293102");
	}

}
