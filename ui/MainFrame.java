package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	ShopPanel shopPanel = new ShopPanel();
	OrderTrack orderTrack = new OrderTrack();
	
	
	
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
		menuBar.add(orders);
		
		login = new JMenu("Login");
		menuBar.add(login);
		
		register = new JMenu("Register");
		menuBar.add(register);
		

		setJMenuBar(menuBar);

		orders.addActionListener(new MenuAction(orderTrack));
		homeshop.addActionListener(new MenuAction(shopPanel));
		
	}
	
	public void initMainFrame () {
		// Frame setup
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(shopPanel);
		setVisible(true);
	}

	
	public MainFrame() {
		super("Welcome!");
		initMenu();
		initMainFrame();
		setLayout(new BorderLayout());
	}

}
