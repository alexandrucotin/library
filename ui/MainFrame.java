package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class MainFrame extends JFrame implements ItemListener {
	
	
	// MENU ITEMS //
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	
	// CARD LAYOUT //
	JPanel cards;
	CardLayout cardLayout = new CardLayout();
	
	
	// PANELS TO SWITCH //
	ShopPanel2 shopPanel = new ShopPanel2();
	OrderTrack orderTrack = new OrderTrack();
	TopBook topBooks = new TopBook();

	public void addComponentToPane(Container pane) {

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(shopPanel, "Shop");
        cards.add(orderTrack, "Order Tracking");
        cards.add(topBooks, "Top Books");
       // cb.addItemListener(this);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    

    
    public  void createAndShowGUI() {

    	// MENU ITEMS //
    	JMenuBar menuBar;
    	JMenu pages, orders, personal, login, register;
    	JMenuItem shop, topBook, orderTracking, personalInfo, orderInfo;
    	
    	// Menu setup
    	menuBar = new JMenuBar();
    			
    	//Items
    	pages = new JMenu("Pages");
    	shop = new JMenuItem("Shop");
    	topBook = new JMenuItem("Top Books");
    	menuBar.add(pages);
    	pages.add(shop);
    	pages.add(topBook);
    	topBook.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent ev) {
    	        CardLayout cl = (CardLayout)(cards.getLayout());
    	        Object source = ev.getSource();
    	        if (source instanceof JMenuItem) {
    	        	JMenuItem menuItem = (JMenuItem)source;
    	            String menuItemTxt = menuItem.getText();
        	        cl.show(cards, menuItemTxt);
    	        }
    	    }
    	});
    	shop.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent ev) {
    	        CardLayout cl = (CardLayout)(cards.getLayout());
    	        Object source = ev.getSource();
    	        if (source instanceof JMenuItem) {
    	        	JMenuItem menuItem = (JMenuItem)source;
    	            String menuItemTxt = menuItem.getText();
        	        cl.show(cards, menuItemTxt);
    	        }
    	    }
    	});
    			
    	orders = new JMenu("Orders");
    	orderTracking = new JMenuItem("Order Tracking");
    	orderInfo = new JMenuItem("Order Info");
    	menuBar.add(orders);
    	
    	orders.add(orderTracking);
    	orderTracking.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent ev) {
    	        CardLayout cl = (CardLayout)(cards.getLayout());
    	        Object source = ev.getSource();
    	        if (source instanceof JMenuItem) {
    	        	JMenuItem menuItem = (JMenuItem)source;
    	            String menuItemTxt = menuItem.getText();
        	        cl.show(cards, menuItemTxt);
    	        }
    	    }
    	});
    	orders.add(orderInfo);
    	orderInfo.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent ev) {
    	        CardLayout cl = (CardLayout)(cards.getLayout());
    	        Object source = ev.getSource();
    	        if (source instanceof JMenuItem) {
    	        	JMenuItem menuItem = (JMenuItem)source;
    	            String menuItemTxt = menuItem.getText();
        	        cl.show(cards, menuItemTxt);
    	        }
    	    }
    	});
    			
    	personal = new JMenu("Personal");
    	personalInfo = new JMenuItem("Personal Info");
    	menuBar.add(personal);
    	personal.add(personalInfo);
    	
    	login = new JMenu("Login");
    	menuBar.add(login);
    			
    	register = new JMenu("Register");
    	menuBar.add(register);
    			
        //Create and set up the window.
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        
        setJMenuBar(menuBar);
        //Display the window.
        
        setSize(600,450);
        setVisible(true);
        addComponentToPane(getContentPane());
        
    }

	public MainFrame() {
		createAndShowGUI();
        
    }
}
