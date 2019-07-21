package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MainFrame {
	
	
	// MENU ITEMS //
	JMenuBar menuBar;
	JMenu homeshop, topCat, orders, login, register, exit;
	
	// CARD LAYOUT //
	JPanel cards;
	CardLayout cardLayout = new CardLayout();
	
	
	// PANELS TO SWITCH //
	ShopPanel shopPanel = new ShopPanel();
	OrderTrack orderTrack = new OrderTrack();
	BookPanel bookPanel = new BookPanel();
	//BookPanel bookPanel = new BookPanel();

	public void addComponentToPane(Container pane) {

        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(shopPanel, "shop");
        cards.add(orderTrack, "order");
        pane.add(cards, BorderLayout.CENTER);
    }
	
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    private static void createAndShowGUI() {

    	// MENU ITEMS //
    	JMenuBar menuBar;
    	JMenu homeshop, topCat, orders, login, register, exit;
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
    			
    	JFrame frame = new JFrame("CardLayoutDemo");
        //Create and set up the window.
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        MainFrame demo = new MainFrame();
        demo.addComponentToPane(frame.getContentPane());
        frame.setJMenuBar(menuBar);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

	public MainFrame() {
		/* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
	}
