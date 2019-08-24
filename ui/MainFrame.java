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
	
	
	
	// CARD LAYOUT //
	JPanel cards;
	CardLayout cardLayout = new CardLayout();
	
	
	// PANELS TO SWITCH //
	ShopPanel shopPanel = new ShopPanel();
	OrderTrack orderTrack = new OrderTrack();
	TopBook topBooks = new TopBook();
	

	UserPage userPage = new UserPage();
	LoginPage loginPage = new LoginPage();
	Basket basket = new Basket();
	RegisterPage registerPage = new RegisterPage();

	public void addComponentToPane(Container pane) {

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(shopPanel, "Shop");
        cards.add(orderTrack, "Order Tracking");
        cards.add(topBooks, "Top Books");
        cards.add(userPage, "Personal Info");
        cards.add(loginPage, "Login");
        cards.add(basket, "Basket Info");
        cards.add(registerPage, "Register");
       // cb.addItemListener(this);
        pane.add(cards, BorderLayout.CENTER);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    public void switchPanel(Container container, String panelName) {
        CardLayout card = (CardLayout) (container.getLayout());
        card.show(container, panelName);
    }
    

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	
	public JPanel getCards() {
		return cards;
	}

	public void setCards(JPanel cards) {
		this.cards = cards;
	}

	public  void createAndShowGUI() {

    	// MENU ITEMS //
    	JMenuBar menuBar;
    	JMenu pages, orders, account ;
    	JMenuItem shop, topBooks, orderTracking, personalInfo, basketInfo, register, login;
    	
    	// Menu setup
    	menuBar = new JMenuBar();
    			
    	//Items
    	pages = new JMenu("Pages");
    	shop = new JMenuItem("Shop");
    	topBooks = new JMenuItem("Top Books");
    	menuBar.add(pages);
    	pages.add(shop);
    	pages.add(topBooks);
    	topBooks.addActionListener(new ActionListener() {
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
    	basketInfo = new JMenuItem("Basket Info");
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
    	orders.add(basketInfo);
    	basketInfo.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent ev) {
    	        CardLayout cl = (CardLayout)(cards.getLayout());
    	        Object source = ev.getSource();
    	        if (source instanceof JMenuItem) {
    	        	JMenuItem menuItem = (JMenuItem)source;
    	            String menuItemTxt = menuItem.getText();
        	        cl.show(cards, menuItemTxt);
        	        repaint();
    	        }
    	    }
    	});
    	
    	account = new JMenu("Account");
    	login = new JMenuItem("Login");
    	register = new JMenuItem("Register");
    	menuBar.add(account);
    	account.add(login);
    	account.add(register);
    	register.addActionListener(new ActionListener() {
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
    	personalInfo = new JMenuItem("Personal Info");
    	account.add(personalInfo);
    	personalInfo.addActionListener(new ActionListener() {
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
    	login.addActionListener(new ActionListener() {
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
    			
        //Create and set up the window.
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        
        setJMenuBar(menuBar);
        //Display the window.
        
        shopPanel.setBasket(basket);
        setSize(650,400);
        setVisible(true);
        addComponentToPane(getContentPane());
        
    }

	public MainFrame() {
		createAndShowGUI();
        
    }
}
