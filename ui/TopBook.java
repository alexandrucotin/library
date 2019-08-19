package ui;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import models.Book;
import singletonConnectionFactory.DBQuery;

public class TopBook extends JPanel {

	private String[][] data;
	private String[] columnNames = { "Title", "Author", "Publishing House", "Category", "Bought Times" };
	private JTable table;
	DefaultTableModel model;

	public List<Book> bookQuery(String query) throws SQLException {
		DBQuery infoBook = new DBQuery();
		List<Book> bookInfo = infoBook.queryTopBooks(query);
		return bookInfo;
	}

	public void initializeTable() {
		this.data = new String[0][columnNames.length];
		this.table = new JTable(data, columnNames);
		this.table.setFillsViewportHeight(true);
		this.table.setPreferredScrollableViewportSize(new Dimension(600, 150));
		this.model = new DefaultTableModel(columnNames, 0);
		this.table.setRowHeight(20);
		JScrollPane sp = new JScrollPane(this.table);
		add(sp);
		model.addRow(new String[columnNames.length]);
		this.table.setModel(model);
	}

	public void bookPanel() {
		try {
			List<Book> bookList = bookQuery(
					"select title, author, publishing_house, category, bought_times from book ORDER BY bought_times DESC");
			for (Book book : bookList) {
				Class cls = book.getClass();
				// returns the array of Field objects
				Field[] fields = cls.getDeclaredFields();
				String[] selectedBook = new String[columnNames.length];
				int j = 0;
				for (int i = 0; i < fields.length; i++) {
					fields[i].setAccessible(true);

					Object value = fields[i].get(book);
					if (value != null) {
						// System.out.println(value);
						selectedBook[j] = value.toString();
						j++;
					}
					
				}
				model.addRow(selectedBook);
			}
			
		} catch (SQLException | IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TopBook() {
		initializeTable();
		// QUERY //
		bookPanel();

	}

}
