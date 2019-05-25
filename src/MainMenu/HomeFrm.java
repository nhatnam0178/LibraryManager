package MainMenu;

import java.awt.EventQueue;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import DAO.ConnectionSQL;
import Models.AuthorTable;
import Models.BookStoreTable;
import Models.BookTable;
import Models.PublisherTable;
import Models.VisitorAddPanel;
import Models.VisitorTable;

import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeFrm extends JMenuBar {

	private JFrame frmLibraryManager;
	private ConnectionSQL conn = new ConnectionSQL();
	private JTabbedPane tabbedPane;
	private JScrollPane[] mySP = new JScrollPane[5];
	private JPanel[] myTables = new JPanel[5];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrm window = new HomeFrm();
					window.frmLibraryManager.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomeFrm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmLibraryManager = new JFrame();
		frmLibraryManager.setTitle("LIBRARY MANAGER");
		frmLibraryManager.setBounds(100, 100, 721, 521);
		frmLibraryManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmLibraryManager.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mExit = new JMenuItem("Exit.");
		mExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		mnFile.add(mExit);

		JMenu mnWindows = new JMenu("Windows");
		menuBar.add(mnWindows);

		JMenuItem mAboutUs = new JMenuItem("About Us.");
		mAboutUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mAboutUs.setVisible(true);
			}
		});
		mnWindows.add(mAboutUs);
		JMenu mnNewMenu = new JMenu("About Us");
		frmLibraryManager.getContentPane().setLayout(null);

		JToolBar myToolBar = new JToolBar();
		myToolBar.setBounds(0, 0, 695, 49);
		frmLibraryManager.getContentPane().add(myToolBar);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					(new VisitorAddPanel()).setVisible(true);
					break;
//				case 1:
//					(new BookPanel(conn, myMother)).show();
//					break;
//				case 2:
//					(new AuthorPanel(conn, myMother)).show();
//					break;
//				case 3:
//					(new PublisherPanel(conn, myMother)).show();
//					break;
//				case 4:
//					(new BookStorePanel(conn, myMother)).show();
//					break;

				default:
					break;
				}

			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Add.png"));
		myToolBar.add(btnAdd);

		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Search.png"));
		myToolBar.add(btnSearch);

		JButton btnModify = new JButton("Modify");
		btnModify.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Modify.png"));
		myToolBar.add(btnModify);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Remove.png"));
		myToolBar.add(btnRemove);

		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Borrow.png"));
		myToolBar.add(btnBorrow);

		JButton btnReturn = new JButton("Return");
		btnReturn.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Return.png"));
		myToolBar.add(btnReturn);

		JButton btnReport = new JButton("Report");
		btnReport.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Report.png"));
		myToolBar.add(btnReport);

		JButton btnMaster = new JButton("Master");
		btnMaster.setIcon(new ImageIcon("C:\\ProjectEclipses\\LibraryManager\\icons\\Master.png"));
		myToolBar.add(btnMaster);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 685, 301);

		frmLibraryManager.getContentPane().add(tabbedPane);

		myTables[0] = new VisitorTable(null);
		myTables[1] = new BookTable(null);
		myTables[2] = new AuthorTable(null);
		myTables[3] = new PublisherTable(null);
		myTables[4] = new BookStoreTable(null);
		mySP[0] = new JScrollPane(myTables[0], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		mySP[1] = new JScrollPane(myTables[1], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySP[2] = new JScrollPane(myTables[2], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySP[3] = new JScrollPane(myTables[3], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mySP[4] = new JScrollPane(myTables[4], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		JScrollPane scVisitor = new JScrollPane();
		scVisitor.setAlignmentY(Component.TOP_ALIGNMENT);
		tabbedPane.addTab("Visitor", null, scVisitor, null);

		JScrollPane scBook = new JScrollPane();
		tabbedPane.addTab("Book", null, scBook, null);

		JScrollPane scAuthor = new JScrollPane();
		tabbedPane.addTab("Author", null, scAuthor, null);

		JScrollPane scPublisher = new JScrollPane();
		tabbedPane.addTab("Publisher", null, scPublisher, null);

		JScrollPane scBookStore = new JScrollPane();
		tabbedPane.addTab("BookStore", null, scBookStore, null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 356, 685, 94);
		frmLibraryManager.getContentPane().add(textArea);

	}
}
