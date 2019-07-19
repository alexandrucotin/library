package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrderTrack extends JPanel {
	private JTextField textField;
	

	public OrderTrack() {
		setLayout(null);
		
		JLabel lblTrackYourOrder = new JLabel("Track Your Order");
		lblTrackYourOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackYourOrder.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblTrackYourOrder.setBounds(134, 71, 172, 43);
		add(lblTrackYourOrder);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setBounds(58, 162, 190, 31);
		add(textField);
		
		JLabel lblInsertOrderId = new JLabel("Insert order ID");
		lblInsertOrderId.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblInsertOrderId.setBounds(58, 142, 89, 20);
		add(lblInsertOrderId);
		
		JButton btnNewButton = new JButton("Track");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(285, 167, 72, 20);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String string = textField.getText();
				new OrderInfo(string).setVisible(true);
			}
		});
		add(btnNewButton);

	}
}
