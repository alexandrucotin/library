package ui;


import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import singletonConnectionFactory.DBQuery;

public class LoginPage extends JPanel {
	
	private JTextField textField, textField1, textField2;
	
	public void goHome() {
		removeAll();
		JLabel exitRegister = new JLabel("Sei stato loggato al sistema!");
		exitRegister.setFont(exitRegister.getFont().deriveFont(24.0f));
		add(exitRegister);
		
		JButton homeButton = new JButton("Torna allo Shop!");
		add(homeButton);
		homeButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	MainFrame mainFrame = new MainFrame();
		        CardLayout cl = (CardLayout) (mainFrame.getCards().getLayout());
		        cl.show(mainFrame.getCards(), "Shop Page");
		    }
		});
		revalidate();
	}
	
	public void goRegister() {
		removeAll();
		JLabel exitRegister = new JLabel("Ti devi registrare!");
		exitRegister.setFont(exitRegister.getFont().deriveFont(24.0f));
		add(exitRegister);
		
		JButton homeButton = new JButton("Registrati!");
		add(homeButton);
		homeButton.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	MainFrame mainFrame = new MainFrame();
		        CardLayout cl = (CardLayout) (mainFrame.getCards().getLayout());
		        cl.show(mainFrame.getCards(), "Register");
		    }
		});
		revalidate();
	}
	
	public boolean loginQuery (String query, String userId, String email, String password, String role) throws SQLException {
		boolean login = false;
		DBQuery infologin = new DBQuery();
		login = infologin.checkLogin(query, userId, email, password, role);
		return login;
	}
	
	public void orderPanel(String userId, String email, String password, String role) {
		
		try {
			String query = "select iduser, email, password from `user`";
			boolean status = loginQuery(query, userId, email, password, role);
			if (status) {
				goHome();
			}else {
				goRegister();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public LoginPage() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		add(Box.createRigidArea(new Dimension(0,25)));
		JLabel lblTrackYourOrder = new JLabel("LOGIN PAGE");
		lblTrackYourOrder.setFont (lblTrackYourOrder.getFont ().deriveFont (32.0f));
		lblTrackYourOrder.setAlignmentX(lblTrackYourOrder.CENTER_ALIGNMENT);
		add(lblTrackYourOrder);

		add(Box.createRigidArea(new Dimension(0,25)));
		JLabel lbluserId = new JLabel("User ID:");
		lbluserId.setFont (lbluserId.getFont ().deriveFont (10.0f));
		add(lbluserId);

		add(Box.createRigidArea(new Dimension(0,5)));
		textField = new JTextField();
		add(textField);
		add(Box.createRigidArea(new Dimension(0,15)));
		
		JLabel lblemail = new JLabel("Email:");
		add(lblemail);
		textField1 = new JTextField();

		add(Box.createRigidArea(new Dimension(0,5)));
		add(textField1);

		add(Box.createRigidArea(new Dimension(0,15)));
		JLabel lblpassword = new JLabel("Pasword:");
		add(lblpassword);
		textField2 = new JTextField();

		add(Box.createRigidArea(new Dimension(0,5)));
		add(textField2);

		add(Box.createRigidArea(new Dimension(0,35)));
		JButton btnNewButton = new JButton("Login");
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// text //
				String userId = textField.getText();
    	    	String email = textField1.getText();
    	    	String password = textField2.getText();
    	    	if (userId != "AD303213") {
        	    	orderPanel(userId,email, password, "R");
    	    	} else {

        	    	orderPanel(userId,email, password, "AD");
    	    	}
    	    	repaint();
			}
    	});

	}
	
	

}
