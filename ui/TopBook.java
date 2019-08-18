package ui;

import java.awt.Dimension;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

import singletonConnectionFactory.MyDataSourceFactory;

public class TopBook extends JPanel {

	/**
	 * Create the panel.
	 */

    private DefaultTableModel model = new DefaultTableModel();
    private JTable jtbl = new JTable(model);
	
	
	public void TopBooks() {
		DataSource ds =  MyDataSourceFactory.getMySQLDataSource();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		model.addColumn("Title");
        model.addColumn("Author");
        model.addColumn("Bought Times");
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select author, title, bought_times from book ORDER BY bought_times ASC");
			while(rs.next()){
				model.addRow(new Object[]{rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4)});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				try {
					if(rs != null) rs.close();
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		JScrollPane sp = new JScrollPane(jtbl); 
		add(sp);
	}
	
}
