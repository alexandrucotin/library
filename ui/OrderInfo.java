package ui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OrderInfo extends JPanel {

	public OrderInfo(String string) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Order Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel.setBounds(91, 38, 244, 61);
		add(lblNewLabel);
		
		JLabel lblBuyier = new JLabel("Order ID");
		lblBuyier.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyier.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBuyier.setBounds(27, 128, 64, 23);
		add(lblBuyier);
		
		JLabel lblNewLabel_1 = new JLabel("Buyer");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(126, 132, 64, 14);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("Order");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(271, 132, 64, 14);
		add(label);
		
		JLabel lblQuiOrderId = new JLabel(string);
		lblQuiOrderId.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiOrderId.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblQuiOrderId.setBounds(27, 193, 64, 23);
		add(lblQuiOrderId);
		
		JLabel lblQuiBuyer = new JLabel("Qui Buyer");
		lblQuiBuyer.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiBuyer.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblQuiBuyer.setBounds(126, 195, 90, 19);
		add(lblQuiBuyer);
		
		JLabel lblQuiOrder = new JLabel("Qui Order");
		lblQuiOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuiOrder.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblQuiOrder.setBounds(228, 193, 185, 55);
		add(lblQuiOrder);

	}


}
