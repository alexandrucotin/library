package ui;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import models.Book;

public class Basket extends JPanel{

	private List<Book> cartItems = new ArrayList <>();
	private String[] columnNames = {"Title", "Price", "Points"};
	private String[][] data;
	private JTable table;
	BasketTableItemModel model;
	
	public void addBasket (Book book) {
		cartItems.add(book);
	}
	
	public void initializeTable() {

		this.data = new String[0][columnNames.length];
		this.table = new JTable(data, columnNames); 
		this.table.setFillsViewportHeight(true);
		this.table.setPreferredScrollableViewportSize(new Dimension(400,300));
		this.model = new BasketTableItemModel(cartItems);
		this.table.setRowHeight(50);
        JScrollPane sp = new JScrollPane(this.table); 
        add(sp);
        this.table.setModel(model);
	}
	

	public Basket() {
		initializeTable();
	}
}
