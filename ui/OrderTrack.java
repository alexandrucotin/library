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

public class OrderTrack extends JPanel {
	
	private String[][] data;
	private String[] columnNames = {"Buyer", "Order Content", "Order Day", "Total Price", "Total Points"}; 
	private JTable table; 
	DefaultTableModel model;
	private Order orderInfo = new Order ();
	private JTextField textField;
	
	public Order orderQuery (String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		orderInfo = infoBook.queryOrder(query);
		return orderInfo;
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
	
	public void orderPanel(String orderId) {
		
		try {
			orderQuery("select iduser, order_content, order_day, tot_price, points from `order` where idorder='" + orderId +"'");
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
	
	public OrderTrack() {

		initializeTable();
		JLabel lblTrackYourOrder = new JLabel("Track Your Order");
		add(lblTrackYourOrder);
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(320,30));
		add(textField);

		JButton btnNewButton = new JButton("Track");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// text //
    	    	String orderId = textField.getText();
    	    	orderPanel(orderId);
    	    	repaint();
			}
    	});
		add(btnNewButton);

	}

}
