package ui;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import singletonConnectionFactory.DBQuery;

public class ShopPanel extends JPanel {
	
	private JList<String> shopList;
	private ArrayList<String> titleBooks;
	
	public ShopPanel() {
		
		// QUERY //
		DBQuery bookTitle = new DBQuery();
		titleBooks = bookTitle.QueryOne("select title from book", "title");
		
		// GRIDBAG LAYOUT //
		setLayout(new GridBagLayout());
		
		// LIST OF BOOKS //
		shopList = new JList(titleBooks.toArray());
		shopList.setVisibleRowCount(6);
		shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(shopList);
	}

}
