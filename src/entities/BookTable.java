/*
 * BookTable.java
 *
 * Created on December 16, 2006, 6:40 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class BookTable extends JPanel {

	/** Creates a new instance of BookTable */
	public BookTable(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			this.conn = conn;
			String query = "Select * from Book;";
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);

			mySPane = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySPane);
		} catch (SQLException ex) {
			ex.getStackTrace();
		}
	}

	public void ChangeModel() {
		String query = "Select * from Book;";
		if (conn == null) {
			return;
		}
		Statement stat;
		try {
			stat = conn.createStatement();

			rs = stat.executeQuery(query);

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	JTable myTable;
	JScrollPane mySPane;
	ResultSet rs;
	Connection conn;
}
