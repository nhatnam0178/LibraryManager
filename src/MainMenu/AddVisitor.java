package MainMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddVisitor extends JDialog {
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtAge;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddVisitor dialog = new AddVisitor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddVisitor() {
		setTitle("Add New Visitor");
		setBounds(100, 100, 411, 439);
		getContentPane().setLayout(null);

		JLabel lblInputInfomationVisitor = new JLabel("INPUT INFOMATION VISITOR");
		lblInputInfomationVisitor.setBounds(134, 11, 178, 14);
		getContentPane().add(lblInputInfomationVisitor);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 37, 46, 14);
		getContentPane().add(lblName);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 79, 46, 14);
		getContentPane().add(lblAddress);

		JLabel lblPhone = new JLabel("Phone :");
		lblPhone.setBounds(10, 127, 46, 14);
		getContentPane().add(lblPhone);

		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(10, 176, 46, 14);
		getContentPane().add(lblAge);

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(10, 225, 46, 14);
		getContentPane().add(lblGender);

		JLabel lblMember = new JLabel("Member :");
		lblMember.setBounds(10, 274, 46, 14);
		getContentPane().add(lblMember);

		txtName = new JTextField();
		txtName.setBounds(66, 34, 295, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(66, 76, 295, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);

		txtPhone = new JTextField();
		txtPhone.setBounds(66, 124, 295, 20);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(66, 173, 295, 20);
		getContentPane().add(txtAge);
		txtAge.setColumns(10);

		JComboBox cbGender = new JComboBox();
		cbGender.setBounds(66, 222, 65, 20);
		getContentPane().add(cbGender);

		JComboBox cbMember = new JComboBox();
		cbMember.setBounds(66, 271, 46, 20);
		getContentPane().add(cbMember);

		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		btnOK.setBounds(179, 366, 94, 23);
		getContentPane().add(btnOK);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(283, 366, 102, 23);
		getContentPane().add(btnCancel);

	}
}
