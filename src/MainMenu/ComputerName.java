package MainMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComputerName extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComputerName dialog = new ComputerName();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComputerName() {
		setTitle("COMPUTER NAME");
		setBounds(100, 100, 734, 481);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//
		setTitle("set Server");
		getContentPane().setLayout(new FlowLayout());
		myPanel.setLayout(new GridLayout(2, 2));
		myPanel.add(ComName);
		myPanel.add(ComNameText);
		myPanel.add(ServPort);
		myPanel.add(ServPortText);
		getContentPane().add(myPanel);
		Ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		getContentPane().add(Ok);
		getContentPane().add(Cancel);
	}

	private JPanel myPanel = new JPanel();
	private JButton Ok = new JButton("Ok");
	private JButton Cancel = new JButton("Cancel");
	private JLabel ComName = new JLabel("Computer Name:");
	private JLabel ServPort = new JLabel("Server Port :");
	private JTextField ComNameText = new JTextField(10);
	private JTextField ServPortText = new JTextField(10);
}
