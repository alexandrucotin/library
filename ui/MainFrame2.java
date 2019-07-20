package ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import singletonConnectionFactory.DBQuery;


public class MainFrame2 extends JFrame{
	
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	ArrayList<String> titleBooks;
	ArrayList<String> priceBooks;
	private OrderTrack orderTrack = new OrderTrack();
	
	private void changePanel(JPanel panel) {
	    getContentPane().removeAll();
	    getContentPane().add(panel, BorderLayout.CENTER);
	    getContentPane().doLayout();
	    update(getGraphics());
	}
	
	private class MenuAction implements ActionListener {
	    private JPanel panel;
	    private MenuAction(JPanel pnl) {
	        this.panel = pnl;
	    }
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        changePanel(panel);

	    }
	}
	
	private void initMenu() {
		// Menu setup
		menuBar = new JMenuBar();
		//Items
		homeshop = new JMenu("Shop");
		menuBar.add(homeshop);
		
		topCat = new JMenu("Top Books");
		menuBar.add(topCat);
		
		orders = new JMenu("Orders");
		orders.addActionListener(new MenuAction(orderTrack));
		menuBar.add(orders);
		
		login = new JMenu("Login");
		menuBar.add(login);
		
		register = new JMenu("Register");
		menuBar.add(register);
		
		setJMenuBar(menuBar);
	}
	
	private void initMainFrame() {
		DBQuery bookTitle = new DBQuery();
		titleBooks = bookTitle.QueryOne("select title from book", "title");
		DBQuery bookPrice = new DBQuery();
		priceBooks = bookPrice.QueryOne("select price from book", "price");
		// Frame setup
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gbl_contentPane);
		
		JLabel lblShop = new JLabel("Online Library");
		lblShop.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblShop = new GridBagConstraints();
		gbc_lblShop.insets = new Insets(0, 0, 5, 5);
		gbc_lblShop.gridwidth = 2;
		gbc_lblShop.gridx = 5;
		gbc_lblShop.gridy = 0;
		add(lblShop, gbc_lblShop);
		
		//////////TITLE	//////////	
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 2;
		add(lblTitle, gbc_lblTitle);
		
		//////////PRICE	//////////
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 6;
		gbc_lblPrice.gridy = 2;
		add(lblPrice, gbc_lblPrice);
		
		for (int i=0; i < titleBooks.size() && i < priceBooks.size(); i++) {
			
			//////////	BOOKS_TITLE	//////////
			JLabel lblBook = new JLabel(titleBooks.get(i));
			GridBagConstraints gbc_lblBook = new GridBagConstraints();
			gbc_lblBook.insets = new Insets(0, 0, 0, 5);
			gbc_lblBook.gridx = 1;
			gbc_lblBook.gridy = 4 + i;
			add(lblBook, gbc_lblBook);
			
			
			//////////	BOOKS_TITLE	//////////			
			JLabel label = new JLabel(priceBooks.get(i));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrice.gridx = 6;
			gbc_lblPrice.gridy = 4 + i;
			add(label, gbc_lblPrice);
			
			
			//////////	CART BUTTON	//////////
			JButton btnAddToCart = new JButton("Add to cart");
			GridBagConstraints gbc_btnAddToCart = new GridBagConstraints();
			gbc_btnAddToCart.gridx = 9;
			gbc_btnAddToCart.gridy = 4+i;
			add(btnAddToCart, gbc_btnAddToCart);
		}
	}
	public MainFrame2() {
		super("Welcome!");
		initMenu();
		initMainFrame();
		
	}

}
