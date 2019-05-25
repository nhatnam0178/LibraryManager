/*
 * VisitorTable.java
 *
 * Created on December 16, 2006, 6:43 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author codemiles
 */
public class VisitorTable extends JPanel {

	/** Creates a new instance of VisitorTable */
	public VisitorTable(Connection conn) {
		if (conn == null) {
			return;
		}
		try {
			this.conn = conn;
			String query = "Select * from Visitor;";
			Statement stat = conn.createStatement();
			rs = stat.executeQuery(query);
			myTable = new JTable();
			add(myTable);
			mySPane = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySPane);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void ChangeModel() {
		String query = "Select * from Visitor;";
		Statement stat;
		if (conn == null) {
			return;
		}
		try {
			stat = conn.createStatement();

			rs = stat.executeQuery(query);

			myTable.setModel(null);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	JTable myTable;
	ResultSet rs;
	JScrollPane mySPane;
	Connection conn;
}
