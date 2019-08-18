package ui;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import models.Book;
import singletonConnectionFactory.DBQuery;

public class ShopPanel extends JPanel {
	
	private JList<String> shopList;
	private ArrayList<String> titleBooks;
	
	int j= 7, k=7;
	JTable table; 
	private Book bookInfo = new Book ();
	
	public Book bookQuery (String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		bookInfo = infoBook.queryBooks(query);
		return bookInfo;
	}
	
	public void BookPanel(String title) {
		setLayout(null);
	
		String[] columnNames = { "ISBN", "Title", "Author", "Publishing House", "Publication Year", "Category", "Price", "Description"}; 
	
		

    	
//	
//		JLabel lblNewLabel = new JLabel("Book Information");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
//		lblNewLabel.setBounds(224, 128, 244, 61);
//		add(lblNewLabel);
//		
//		JLabel lblBuyier = new JLabel("Title");
//		lblBuyier.setHorizontalAlignment(SwingConstants.CENTER);
//		lblBuyier.setFont(new Font("Calibri", Font.PLAIN, 18));
//		lblBuyier.setBounds(17, 178, 150, 23);
//		add(lblBuyier);
//		
//		JLabel lblNewLabel_1 = new JLabel("Author");
//		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
//		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel_1.setBounds(271, 178, 150, 23);
//		add(lblNewLabel_1);
//		
//		JLabel label = new JLabel("Publisher");
//		label.setHorizontalAlignment(SwingConstants.CENTER);
//		label.setFont(new Font("Calibri", Font.PLAIN, 18));
//		label.setBounds(525, 178, 150, 23);
//		add(label);
//		
//		JLabel lblPrice = new JLabel("Category");
//		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
//		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 18));
//		lblPrice.setBounds(17, 260, 150, 23);
		/*
		 * add(lblPrice);
		 * 
		 * JLabel lblPoints = new JLabel("Price"); lblPoints.setFont(new Font("Calibri",
		 * Font.PLAIN, 18)); lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		 * lblPoints.setBounds(271, 260, 150, 23); add(lblPoints);
		 * 
		 * JLabel labelPayment = new JLabel("Points");
		 * labelPayment.setHorizontalAlignment(SwingConstants.CENTER);
		 * labelPayment.setFont(new Font("Calibri", Font.PLAIN, 18)); labelP
			payment.setBounds(525, 260, 150, 23); add(labelPayment);
		  */
		
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
	         String[] arr = new String[fields.length];
	         for(int i = 0; i < fields.length; i++) {
	        	fields[i].setAccessible(true);
	            Object value = fields[i].get(bookInfo);
		        //System.out.println(value);
	            arr[i] = value.toString();
		        JLabel lblQuiOrderId = new JLabel(value.toString());
		        lblQuiOrderId.setHorizontalAlignment(SwingConstants.CENTER);
				lblQuiOrderId.setFont(new Font("Calibri", Font.PLAIN, 18));
				if(i<fields.length/2) {
					lblQuiOrderId.setBounds(7+j, 205, 200, 23);
					add(lblQuiOrderId);
					j= j+254;
				
				}else {
					lblQuiOrderId.setBounds(7+k, 280, 150, 23);
					add(lblQuiOrderId);
					k= k+254;
				}
	         }
	        String[][] data = new String[arr.length][1];
	        for ( int i = 0; i < arr.length; i++ ){
	        	data[i][0] = arr[i];
	        }
	        table = new JTable(data, columnNames); 
	 		table.setBounds(30, 40, 200, 300); 
	 		
	         // adding it to JScrollPane 
	        
	      } catch(Exception e) {
	         System.out.println(e.toString());
	      }
		 
	}
	
	public ShopPanel() {
		JPanel parent = this;
		// QUERY //
		DBQuery bookTitle = new DBQuery();
		titleBooks = bookTitle.queryOne("select title from book", "title");
		// GRIDBAG LAYOUT //
		setLayout(new GridBagLayout());
		
		// LIST OF BOOKS //
		
		shopList = new JList(titleBooks.toArray());
		shopList.setVisibleRowCount(6);
		shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		
		MouseListener mouseListener = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
	        if (e.getClickCount() == 2) {
		           String selectedItem = (String) shopList.getSelectedValue();
		           BookPanel(selectedItem);
		         }
	        repaint();
		    }
		};
		
		JScrollPane sp = new JScrollPane(table);
		shopList.addMouseListener(mouseListener);
		add(shopList);
		add(sp);
	}

}
