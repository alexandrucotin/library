package ui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import models.Book;

public class BasketTableItemModel extends AbstractTableModel {
	private List<Book> books;

	public BasketTableItemModel(List<Book> cartItems) {
		this.books = cartItems;
	}

	@Override
	public int getRowCount() {
		return books.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Object value = "??";
		Book book = books.get(rowIndex);
		switch (columnIndex) {
		case 0:
			value = book.getTitle();
			break;
		case 1:
			value = book.getPrice();
			break;
		case 2:
			value = book.getPoints();
			break;

		}

		return value;
	}

}
