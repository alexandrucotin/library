package ui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import models.Book;
import singletonConnectionFactory.DBQuery;

public class ShopPanel extends JPanel {

	private JList<Book> shopList;
	private List<Book> books;
	private String[][] data;
	private String[] columnNames = { "Title", "Author", "Publishing House", "Category", "Price" };
	private JTable table;
	DefaultTableModel model;
	private Book bookInfo = new Book();
	private Book selectedItem;
	private Basket basket;
	
	
	public Book bookQuery(String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		bookInfo = infoBook.queryBook(query);
		return bookInfo;
	}

	public void initializeTable() {

		this.data = new String[0][columnNames.length];
		this.table = new JTable(data, columnNames);
		this.table.setFillsViewportHeight(true);
		this.table.setPreferredScrollableViewportSize(new Dimension(600, 50));
		this.model = new DefaultTableModel(columnNames, 0);
		this.table.setRowHeight(50);
		JScrollPane sp = new JScrollPane(this.table);
		add(sp);
		model.addRow(new String[columnNames.length]);
		this.table.setModel(model);
	}

	public void bookPanel(String title) {
		try {
			bookQuery("select title, author, publishing_house, category, price from book where title='" + title + "'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {

			Class cls = bookInfo.getClass();
			// returns the array of Field objects
			Field[] fields = cls.getDeclaredFields();
			data = new String[1][6];

			int selectedField = 0;
			for (int i = 0; i < fields.length; i++) {
				fields[i].setAccessible(true);

				Object value = fields[i].get(bookInfo);
				if (value != null) {
					// System.out.println(value);
					data[0][selectedField] = value.toString();
					model.setValueAt(value.toString(), 0, selectedField);
					selectedField++;
				}
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public void setBasket (Basket basket) {
		this.basket = basket;
	}

	public ShopPanel() {
		initializeTable();
		// QUERY //
		DBQuery bookTitle = new DBQuery();

		DefaultListModel<Book> listMod = new DefaultListModel<>();
		
		try {
			books = bookTitle.queryBooks("select title, price, points from book");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (Book book : books) {
			listMod.addElement(book);
		}

		// LIST OF BOOKS //
		
		shopList = new JList<Book>(listMod);
		shopList.setVisibleRowCount(6);
		shopList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		shopList.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (renderer instanceof JLabel && value instanceof Book) {
					// Here value will be of the Type 'CD'
					((JLabel) renderer).setText(((Book) value).getTitle());
				}
				return renderer;
			}
		});

		MouseListener mouseListener = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					selectedItem = shopList.getSelectedValue();
					bookPanel(selectedItem.getTitle());
					repaint();
				}
			}
		};
		shopList.addMouseListener(mouseListener);
		add(shopList);

		add(Box.createRigidArea(new Dimension(0, 35)));
		JButton btnNewButton = new JButton("Add To Cart");
		add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				basket.addBasket(selectedItem);
				repaint();
			}
		});
	}

}
