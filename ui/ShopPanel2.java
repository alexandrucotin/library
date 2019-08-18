package ui;


import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.Book;
import singletonConnectionFactory.DBQuery;

public class ShopPanel2 extends JPanel {
	
	private JList<String> shopList;
	private ArrayList<String> titleBooks;
	private String[][] data;
	private String[] columnNames = { "ISBN", "Title", "Author", "Publishing House", "Publication Year", "Category", "Price", "Description", "Points", "Bought Times"}; 
	private JTable table; 
	DefaultTableModel model;
	
	private Book bookInfo = new Book ();
	
	public Book bookQuery (String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		bookInfo = infoBook.queryBook(query);
		return bookInfo;
	}
	
	public void initializeTable() {

		this.data = new String[0][columnNames.length];
		this.table = new JTable(data, columnNames); 
		this.table.setFillsViewportHeight(true);
		this.table.setPreferredScrollableViewportSize(new Dimension(900,50));
		this.model = new DefaultTableModel(columnNames,0);      
        JScrollPane sp = new JScrollPane(this.table); 
        add(sp);
        model.addRow(new String[columnNames.length]);
        this.table.setModel(model);
	}
	
	public void bookPanel(String title) {
		try {
			bookQuery("select * from book where title='" + title +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {            
	         Class cls = bookInfo.getClass();
	         // returns the array of Field objects
	         Field[] fields = cls.getDeclaredFields();
		     data = new String[1][fields.length];
	         for(int i = 0; i < fields.length; i++) {
	        	fields[i].setAccessible(true);
	            Object value = fields[i].get(bookInfo);
		        //System.out.println(value);
	            data[0][i] = value.toString();
	            model.setValueAt(value.toString(), 0, i);
	         }
	      } catch(Exception e) {
	         System.out.println(e.toString());
	      }
	}
	
	public ShopPanel2() {
		initializeTable();
		
		// QUERY //
		DBQuery bookTitle = new DBQuery();
		titleBooks = bookTitle.queryOne("select title from book", "title");
		
		// LIST OF BOOKS //
		shopList = new JList(titleBooks.toArray());
		shopList.setVisibleRowCount(6);
		shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
	        if (e.getClickCount() == 1) {
		           String selectedItem = (String) shopList.getSelectedValue();
		   			bookPanel(selectedItem);
		   			repaint();
		         }
		    }
		};
		shopList.addMouseListener(mouseListener);
		add(shopList);
	}

}
