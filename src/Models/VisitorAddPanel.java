package Models;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class VisitorAddPanel extends JDialog {
	private JTextField txtAddress;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtPayment;
	private JTextField txtMemberEnd;
	private JTextField txtSerial;

	/**
	 * Create the dialog.
	 */
	public VisitorAddPanel() {
		setTitle("Add New Visitor");
		setBounds(100, 100, 362, 414);
		getContentPane().setLayout(null);

		JCheckBox isMemberCb = new JCheckBox("Is Memeber");
		boolean selected = isMemberCb.isSelected();
		isMemberCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected) {
					txtPayment.setEditable(true);
					txtMemberEnd.setEditable(true);
					txtSerial.setEditable(true);
				} else {
					txtPayment.setEditable(false);
					txtMemberEnd.setEditable(false);
					txtSerial.setEditable(false);
				}
			}
		});
		isMemberCb.setBounds(6, 186, 97, 23);
		getContentPane().add(isMemberCb);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOk.setBounds(148, 346, 89, 23);
		getContentPane().add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(247, 346, 89, 23);
		getContentPane().add(btnCancel);

		JPanel addpanel = new JPanel();
		addpanel.setBorder(new TitledBorder(null, "Input Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addpanel.setBounds(6, 8, 330, 171);
		getContentPane().add(addpanel);
		addpanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Name : ");
			lblName.setBounds(10, 34, 37, 14);
			addpanel.add(lblName);
		}
		{
			JLabel lblPhoneNo = new JLabel("Phone No :");
			lblPhoneNo.setBounds(10, 59, 53, 14);
			addpanel.add(lblPhoneNo);
		}
		{
			JLabel lblAge = new JLabel("Age :");
			lblAge.setBounds(10, 84, 26, 14);
			addpanel.add(lblAge);
		}

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(10, 133, 42, 14);
		addpanel.add(lblGender);

		txtAddress = new JTextField();
		txtAddress.setBounds(73, 105, 245, 20);
		addpanel.add(txtAddress);
		txtAddress.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(73, 31, 245, 20);
		addpanel.add(txtName);
		txtName.setColumns(10);
		{
			JLabel lblAddress = new JLabel("Address :");
			lblAddress.setBounds(10, 108, 46, 14);
			addpanel.add(lblAddress);
		}

		txtPhone = new JTextField();
		txtPhone.setBounds(73, 56, 245, 20);
		addpanel.add(txtPhone);
		txtPhone.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(73, 81, 245, 20);
		addpanel.add(txtAge);
		txtAge.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(73, 130, 97, 20);
		addpanel.add(comboBox);

		JPanel panelMember = new JPanel();
		panelMember.setBorder(
				new TitledBorder(null, "Input Info Member", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelMember.setBounds(6, 216, 330, 119);
		getContentPane().add(panelMember);
		panelMember.setLayout(null);

		JLabel lblPayment = new JLabel("Payment :");
		lblPayment.setBounds(10, 29, 65, 14);
		panelMember.add(lblPayment);

		JLabel lblMembershipend = new JLabel("MemberShipEnd : ");
		lblMembershipend.setBounds(10, 54, 92, 14);
		panelMember.add(lblMembershipend);

		JLabel lblSerial = new JLabel("Serial : ");
		lblSerial.setBounds(10, 79, 46, 14);
		panelMember.add(lblSerial);

		txtPayment = new JTextField();
		txtPayment.setBounds(97, 26, 223, 20);
		panelMember.add(txtPayment);
		txtPayment.setColumns(10);

		txtMemberEnd = new JTextField();
		txtMemberEnd.setBounds(97, 51, 223, 20);
		panelMember.add(txtMemberEnd);
		txtMemberEnd.setColumns(10);

		txtSerial = new JTextField();
		txtSerial.setBounds(97, 76, 223, 20);
		panelMember.add(txtSerial);
		txtSerial.setColumns(10);

	}
}
