/**package ui;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import singletonConnectionFactory.DBQuery;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JTextPane;

public class BookPanel extends JPanel {

	private ArrayList<String> bookInfo;
	
	
	private ArrayList<String> bookQuery (String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		bookInfo = infoBook.QueryAll(query);
		return bookInfo;
	}

	
	public BookPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		
		// Title //
		JLabel lblBookInfo = new JLabel("Book Info");
		GridBagConstraints gbc_lblBookInfo = new GridBagConstraints();
		gbc_lblBookInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblBookInfo.gridx = 6;
		gbc_lblBookInfo.gridy = 1;
		add(lblBookInfo, gbc_lblBookInfo);
		
		
		// Label //
		JLabel lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 3;
		add(lblTitle, gbc_lblTitle);
		
		JLabel lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 4;
		gbc_lblAuthor.gridy = 3;
		add(lblAuthor, gbc_lblAuthor);
		
		JLabel lblPrice = new JLabel("Price");
		GridBagConstraints gbc_lblPrice = new GridBagConstraints();
		gbc_lblPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrice.gridx = 8;
		gbc_lblPrice.gridy = 3;
		add(lblPrice, gbc_lblPrice);
		
		JLabel lblPoints = new JLabel("Points");
		GridBagConstraints gbc_lblPoints = new GridBagConstraints();
		gbc_lblPoints.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoints.gridx = 10;
		gbc_lblPoints.gridy = 3;
		add(lblPoints, gbc_lblPoints);
		
		
		// BOOK INFO //
		for (int i=0; i<bookInfo.size(); i++) {
			JLabel lblTitle_1 = new JLabel(bookInfo.get(i));
			GridBagConstraints gbc_lblTitle_1 = new GridBagConstraints();
			gbc_lblTitle_1.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle_1.gridx = 0+i;
			gbc_lblTitle_1.gridy = 4;
			add(lblTitle_1, gbc_lblTitle_1);
		}
		
		JLabel lblDescription = new JLabel("Description");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 6;
		gbc_lblDescription.gridy = 6;
		add(lblDescription, gbc_lblDescription);
		
		JTextPane textPane = new JTextPane();
		GridBagConstraints gbc_textPane = new GridBagConstraints();
		gbc_textPane.gridheight = 2;
		gbc_textPane.gridwidth = 5;
		gbc_textPane.insets = new Insets(0, 0, 5, 5);
		gbc_textPane.fill = GridBagConstraints.BOTH;
		gbc_textPane.gridx = 4;
		gbc_textPane.gridy = 7;
		add(textPane, gbc_textPane);
		
	}

}
*/