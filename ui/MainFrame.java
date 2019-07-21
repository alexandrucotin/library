package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	
	// MENU ITEMS //
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	
	// CARD LAYOUT //
	JPanel panelCont = new JPanel();
	CardLayout cardLayout = new CardLayout();
	
	
	// PANELS TO SWITCH //
	ShopPanel shopPanel = new ShopPanel();
	OrderTrack orderTrack = new OrderTrack();
	BookPanel bookPanel = new BookPanel();
	//BookPanel bookPanel = new BookPanel();

	
	private void initMenu() {
		// Menu setup
		menuBar = new JMenuBar();
		
		//Items
		
		homeshop = new JMenu("Shop");
		menuBar.add(homeshop);
		
		topCat = new JMenu("Top Books");
		menuBar.add(topCat);
		
		orders = new JMenu("Orders");
		menuBar.add(orders);
		
		login = new JMenu("Login");
		menuBar.add(login);
		
		register = new JMenu("Register");
		menuBar.add(register);
		

		setJMenuBar(menuBar);
		
		homeshop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(panelCont, "shopPage");
			}
		});
		
		orders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(panelCont, "orderTrack");
			}
		});
		
	}

	public MainFrame() {
		super("Welcome!");
		initMenu();
		setSize(400, 150);
		add(panelCont);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		panelCont.setLayout(cardLayout);
		panelCont.add(shopPanel, "shopPage");
		panelCont.add(orderTrack, "orderTrack");
		panelCont.add(bookPanel, "bookPage");
		cardLayout.show(panelCont,"bookPage");
	}

}
