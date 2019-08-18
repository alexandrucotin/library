package ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.xml.internal.ws.api.Component;

import singletonConnectionFactory.DBQuery;

public class OrderTrack extends JPanel {

	JPanel infoPanel = new JPanel();
	private JTextField textField;
	public ArrayList<String> orderInfo = new ArrayList<String>();
	int j =7, k=7;
	
	
	public ArrayList<String> orderQuery (String query) throws SQLException {
		DBQuery infoOrder = new DBQuery();
		orderInfo = infoOrder.queryAll(query);

		System.out.println(orderInfo);
		return orderInfo;
	}


	public OrderTrack() { 
		JPanel test = new JPanel();
		setLayout(null);
		JPanel parent = this;
		
		JLabel lblTrackYourOrder = new JLabel("Track Your Order");
		lblTrackYourOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrackYourOrder.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblTrackYourOrder.setBounds(264, 21, 172, 43);
		add(lblTrackYourOrder);
		
		textField = new JTextField();
		textField.setFont(new Font("Calibri", Font.PLAIN, 16));
		textField.setBounds(208, 92, 190, 31);
		add(textField);
		
		JLabel lblInsertOrderId = new JLabel("Insert order ID");
		lblInsertOrderId.setFont(new Font("Calibri", Font.PLAIN, 10));
		lblInsertOrderId.setBounds(208, 72, 89, 20);
		add(lblInsertOrderId);
		

		JButton btnNewButton = new JButton("Track");
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnNewButton.setBounds(415, 97, 72, 20);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				// text //
    	    	String orderId = textField.getText();
    	    	
    	    	//remove existing stuff //
//				for (java.awt.Component c : parent.getComponents()) {
//				    parent.remove();
//				}
    	    	
    	    	OrderInfo(orderId);
    	    	repaint();
			}
    	});
		add(btnNewButton);
	}
	
	public JPanel OrderInfo(String orderId) {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Order Information");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		lblNewLabel.setBounds(224, 128, 244, 61);
		add(lblNewLabel);
		
		JLabel lblBuyier = new JLabel("Order Time");
		lblBuyier.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuyier.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBuyier.setBounds(17, 178, 150, 23);
		add(lblBuyier);
		
		JLabel lblNewLabel_1 = new JLabel("Content Order");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(271, 178, 150, 23);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("Buyer");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(525, 178, 150, 23);
		add(label);
		
		JLabel lblPrice = new JLabel("Total Price");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPrice.setBounds(17, 260, 150, 23);
		add(lblPrice);
		
		JLabel lblPoints = new JLabel("Total Points");
		lblPoints.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPoints.setHorizontalAlignment(SwingConstants.CENTER);
		lblPoints.setBounds(271, 260, 150, 23);
		add(lblPoints);
		
		JLabel labelPayment = new JLabel("Payment Type");
		labelPayment.setHorizontalAlignment(SwingConstants.CENTER);
		labelPayment.setFont(new Font("Calibri", Font.PLAIN, 18));
		labelPayment.setBounds(525, 260, 150, 23);
		add(labelPayment);
		
		try {
			orderQuery("select order_day, order_content, iduser, tot_price, points, payment_type from `order` where idorder='" + orderId +"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int sizeArray = orderInfo.size();
		for (int i=0; i<sizeArray; i++) {
			JLabel lblQuiOrderId = new JLabel(orderInfo.get(i));
			lblQuiOrderId.setHorizontalAlignment(SwingConstants.CENTER);
			lblQuiOrderId.setFont(new Font("Calibri", Font.PLAIN, 18));
			if(i<sizeArray/2) {
				lblQuiOrderId.setBounds(7+j, 205, 200, 23);
				add(lblQuiOrderId);
				j= j+254;
			
			}else {
				lblQuiOrderId.setBounds(7+k, 280, 150, 23);
				add(lblQuiOrderId);
				k= k+254;
			}
			
		
		}
		
		return infoPanel;
	}
}
