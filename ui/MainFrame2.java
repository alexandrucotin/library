package ui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class MainFrame2 {
	JFrame frame = new JFrame("CardLayout");
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	JPanel panelCont = new JPanel();
	ShopPanel shopPanel = new ShopPanel();
	OrderTrack orderTrack = new OrderTrack();
	//BookPanel bookPanel = new BookPanel();
	CardLayout cardLayout = new CardLayout();

	
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
		

		frame.setJMenuBar(menuBar);
		
		homeshop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(panelCont, "1");
			}
		});
		
		orders.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			cardLayout.show(panelCont, "3");
			}
		});
		
	}
	
	public void Clayout() {
		panelCont.setLayout(cardLayout);
		panelCont.add(shopPanel, "1");
		panelCont.add(orderTrack, "3");
		cardLayout.show(panelCont,"1");
	}
	public void initMainFrame () {
		// Frame setup
		frame.add(panelCont);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	
	public MainFrame2() {
		initMenu();
		initMainFrame();
	}

}
