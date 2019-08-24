package ui;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.UUID;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ui.MainFrame;
import singletonConnectionFactory.DBQuery;

public class RegisterPage extends JPanel {

	private JTextField nameField, lastNameField, addressField, address2Field, capField, cityField, phoneField,
			emailField, passwordField;

	private void changeStatus(boolean pressed) {
		pressed = !pressed;
	}

	public void goHome() {

		boolean pressed = false;
		removeAll();
		JLabel exitRegister = new JLabel("Sei stato registrato al sistema!");
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
				changeStatus(pressed);
			}
		});
		if (pressed) {
			removeAll();
			JLabel exitRegister2 = new JLabel("Sei stato registrato al sistema!");
			add(exitRegister2);
			revalidate();
		}
	}

	public void registerQuery(String userId, String name, String lastName, String address, String address2, String cap,
			String city, String phoneNumber, String email, String bookCardId, String password) {
		DBQuery queryDB = new DBQuery();
		try {
			String query = "INSERT INTO `user` VALUES ('" + userId + "'," + "'R'," + "'" + name + "'," + "'" + lastName
					+ "'," + "'" + address + "'," + "'" + address2 + "'," + cap + "," + "'" + city + "'," + phoneNumber
					+ "," + "'" + email + "'," + "'" + bookCardId + "'," + "'" + password + "');";
			System.out.println(query);
			queryDB.queryRegister(query);
			boolean status = queryDB.statusUser(userId, email, "`user`");
			if (status) {
				goHome();
				revalidate();
			} else {
				System.out.println("Qualcosa non va!");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public RegisterPage() {

		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel centerPanel = new JPanel();
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		JLabel lblTrackYourOrder = new JLabel("REGISTER FORM");
		lblTrackYourOrder.setFont(lblTrackYourOrder.getFont().deriveFont(24.0f));

		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
		// LEFT PANEL //

		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));

		JLabel lblName = new JLabel("Name:");
		leftPanel.add(lblName);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		nameField = new JTextField();
		leftPanel.add(nameField);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblLastName = new JLabel("Last Name:");
		leftPanel.add(lblLastName);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		lastNameField = new JTextField();
		leftPanel.add(lastNameField);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lbladdress = new JLabel("Address:");
		leftPanel.add(lbladdress);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		addressField = new JTextField();
		leftPanel.add(addressField);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblAddress2 = new JLabel("Address #2 (Optional):");
		leftPanel.add(lblAddress2);

		leftPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		address2Field = new JTextField();
		leftPanel.add(address2Field);

		// Right PANEL //

		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));

		JLabel lblCAP = new JLabel("CAP:");
		rightPanel.add(lblCAP);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		capField = new JTextField();
		rightPanel.add(capField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		// CITY LBL & JTEXT //

		JLabel lblCity = new JLabel("City:");
		rightPanel.add(lblCity);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		cityField = new JTextField();
		rightPanel.add(cityField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblPhone = new JLabel("Phone Number:");
		rightPanel.add(lblPhone);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		phoneField = new JTextField();
		rightPanel.add(phoneField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblEmail = new JLabel("Email:");
		rightPanel.add(lblEmail);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		emailField = new JTextField();
		rightPanel.add(emailField);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 15)));

		JLabel lblPassword = new JLabel("Password:");
		rightPanel.add(lblPassword);

		rightPanel.add(Box.createRigidArea(new Dimension(0, 5)));

		passwordField = new JTextField();
		rightPanel.add(passwordField);

		JButton btnNewButton = new JButton("Register");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// text //
				String userId = UUID.randomUUID().toString().replace("-", "");
				String bookCardId = UUID.randomUUID().toString();
				String name = nameField.getText();
				String lastName = lastNameField.getText();
				String address = addressField.getText();
				String address2 = address2Field.getText();
				String cap = capField.getText();
				String city = cityField.getText();
				String phoneNumber = phoneField.getText();
				String email = emailField.getText();
				String password = passwordField.getText();
				registerQuery(userId, name, lastName, address, address2, cap, city, phoneNumber, email, bookCardId,
						password);

				repaint();
			}
		});

		add(lblTrackYourOrder);
		centerPanel.add(leftPanel);
		centerPanel.add(Box.createRigidArea(new Dimension(15, 0)));
		centerPanel.add(rightPanel);
		add(centerPanel);
		add(Box.createRigidArea(new Dimension(0, 15)));
		add(btnNewButton);

	}

}
