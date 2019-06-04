package MainMenu;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import Models.ConnectionSQL;
import Models.MemberAddPanel;
import Models.MemberEditPanel;
import Models.MemberTable;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomeFrm extends JMenuBar {

	private JFrame frmLibraryManager;
	private ConnectionSQL conn;
	private JTabbedPane tabbedPane;
	private JScrollPane[] mySP = new JScrollPane[5];
	private JPanel[] myTables = new JPanel[5];
	private JTextField txtSearch;

//	private myToolbar myToolbar;
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
		myToolBar.setBounds(0, 0, 465, 49);
		frmLibraryManager.getContentPane().add(myToolBar);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 685, 301);

		frmLibraryManager.getContentPane().add(tabbedPane);

		myTables[0] = new MemberTable();
		
		
		mySP[0] = new JScrollPane(myTables[0], JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

//		myToolBar = new
//	
//				
		JPanel pMember = new JPanel();
		tabbedPane.addTab("Member", mySP[0]);
		JPanel pBook = new JPanel();
		tabbedPane.addTab("Book", mySP[1]);

		JPanel pAuthor = new JPanel();
		tabbedPane.addTab("Author", mySP[2]);

		JPanel pPublisher = new JPanel();
		tabbedPane.addTab("Publisher", mySP[3]);

		JPanel pBookStore = new JPanel();
		tabbedPane.addTab("BookStore", mySP[4]);

		JButton btnAdd = new JButton("Add");
		btnAdd.setToolTipText("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					(new MemberAddPanel()).setVisible(true);
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
		btnAdd.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Add.png")));
		myToolBar.add(btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch (tabbedPane.getSelectedIndex()) {
				case 0:
					(new MemberEditPanel()).setVisible(true);
					break;

				}
			}
		});
		btnEdit.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Modify.png")));
		myToolBar.add(btnEdit);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Remove.png")));
		myToolBar.add(btnRemove);

		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Borrow.png")));
		myToolBar.add(btnBorrow);

		JButton btnReturn = new JButton("Return");
		btnReturn.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Return.png")));
		myToolBar.add(btnReturn);

		JButton btnMaster = new JButton("Master");
		btnMaster.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Master.png")));
		myToolBar.add(btnMaster);

		JTextArea txtNotification = new JTextArea();
		txtNotification.setBounds(10, 356, 685, 94);
		frmLibraryManager.getContentPane().add(txtNotification);

		txtSearch = new JTextField();
		txtSearch.setToolTipText("Input Keyword!");
		txtSearch.setBounds(537, 12, 156, 20);
		frmLibraryManager.getContentPane().add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setBounds(475, 8, 57, 31);
		frmLibraryManager.getContentPane().add(btnSearch);
		btnSearch.setIcon(new ImageIcon(HomeFrm.class.getResource("/icons/Search.png")));

	}

}
