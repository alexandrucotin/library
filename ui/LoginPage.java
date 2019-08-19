package ui;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import models.Order;
import singletonConnectionFactory.DBQuery;

public class LoginPage extends JPanel {
	
	private JTextField textField, textField1, textField2;
	String query;
	
	public boolean loginQuery (String query, String userId, String email, String password) throws SQLException {
		boolean login = false;
		DBQuery infologin = new DBQuery();
		login = infologin.checkLogin(query, userId, email, password);
		return login;
	}
	
	public boolean statusQuery (String query, String userId, String email, String password) throws SQLException {
		boolean status = false;
		DBQuery infoBook = new DBQuery();
		status = infoBook.statusUser(query, userId, email, password);
		return status;
	}	
	
	public void orderPanel(String userId, String email, String password) {
		
		try {
			query = "select email, password from user where email='" + email +"'";
			loginQuery(query, userId, email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {     

	         Class cls = orderInfo.getClass();
	         // returns the array of Field objects
	         Field[] fields = cls.getDeclaredFields();
		     data = new String[1][columnNames.length];

		 	int selectedField = 0;
	         for(int i = 0; i < fields.length; i++) {
	        	fields[i].setAccessible(true);
	        	
	            Object value = fields[i].get(orderInfo);
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
	
	public LoginPage() {
		JLabel lblTrackYourOrder = new JLabel("LOGIN PAGE");
		add(lblTrackYourOrder);
		
		JLabel lbluserId = new JLabel("User ID:");
		add(lbluserId);
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(320,30));
		add(textField);
		
		
		JLabel lblemail = new JLabel("Email:");
		add(lblemail);
		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(320,30));
		add(textField1);
		
		JLabel lblpassword = new JLabel("Pasword:");
		add(lblpassword);
		textField2 = new JTextField();
		textField2.setPreferredSize(new Dimension(320,30));
		add(textField2);

		JButton btnNewButton = new JButton("Login");
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// text //
				String userId = textField.getText();
    	    	String email = textField1.getText();
    	    	String password = textField2.getText();
    	    	orderPanel(userId,email, password);
    	    	repaint();
			}
    	});

	}

}
