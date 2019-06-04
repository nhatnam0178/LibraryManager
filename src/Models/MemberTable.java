package Models;

import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MemberTable extends JPanel {
	JTable myTable;
	ResultSet rs;
	JScrollPane mySPane;

	CashingResultTableModel myModel;

	/** Creates a new instance of MemberTable */
	public MemberTable() {
		ConnectionSQL conn = new ConnectionSQL();
		if (conn == null) {
			System.out.println("Connect Failed");
		}
		try {
			conn.Connect();
			String query = "Select * from Member";

			rs = conn.Query(query);
			myModel = new CashingResultTableModel(rs);
			myTable = new JTable(myModel);
			myTable.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					ListSelectionModel rowSM = myTable.getSelectionModel();

					rowSM.addListSelectionListener(new ListSelectionListener() {

						@Override
						public void valueChanged(ListSelectionEvent e) {
							// TODO Auto-generated method stub
							int selectedRow;
							ListSelectionModel lsm = (ListSelectionModel) e.getSource();

							selectedRow = lsm.getMinSelectionIndex();

							int numCols = myTable.getColumnCount();
							CashingResultTableModel model = new CashingResultTableModel(rs);
							model = (CashingResultTableModel) myTable.getModel();

							System.out.print(" \n row " + selectedRow + ":");

							for (int j = 0; j < numCols; j++) {
								System.out.print(" " + model.getValueAt(selectedRow, j));
							}
						}
					});
				}
			});
			add(myTable);
			resizeColumnWidth(myTable);

			mySPane = new JScrollPane(myTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			add(mySPane);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void ChangeModel() {
		ConnectionSQL conn = new ConnectionSQL();
		String query = "Select * from Member";
		if (conn == null) {
			System.out.println("Connect Failed");
		}
		try {
			String qr = "Select * from Member";

			rs = conn.Query(qr);
			myModel = new CashingResultTableModel(rs);
			myTable.setModel(myModel);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void resizeColumnWidth(JTable table) {
		final TableColumnModel columnModel = table.getColumnModel();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		for (int column = 0; column < table.getColumnCount(); column++) {
			int width = 15; // Min width
			for (int row = 0; row < table.getRowCount(); row++) {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component comp = table.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300)
				width = 300;
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}

}
