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
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import DAO.Repositories;
import entities.Member;
import java.awt.Component;
import javax.swing.JRadioButton;
import javax.swing.DefaultComboBoxModel;

public class MemberAddPanel extends JDialog {
	private JTextField txtPhoneNum;
	private JTextField txtfullName;
	private JTextField txtAge;
	private JTextField txtAddress;
	private JTextField txtPayment;
	private JTextField txtMemberEnd;
	private JTextField txtSerial;
	private ConnectionSQL conn;
	private MyComboBox cbGender = new MyComboBox();
	private MyComboBox cbStatus = new MyComboBox();

	Repositories rep = new Repositories();
	private JTextField txtNumOf;

	/**
	 * Create the dialog.
	 */
	public MemberAddPanel() {
		setTitle("Add New Member");
		setBounds(100, 100, 395, 386);
		getContentPane().setLayout(null);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String fullName = txtfullName.getText();
				int age = Integer.parseInt(txtAge.getText());
				byte gender = 0;
				String obj = (String) cbGender.getSelectedItem();
				if (obj == "Male") {
					gender = 1;
				}
				String phoneNum = txtPhoneNum.getText();
				String address = txtAddress.getText();
				int numOf_BorrBook = Integer.parseInt(txtNumOf.getText());
				byte status = 0;
				String objStatus = (String) cbStatus.getSelectedItem();
				if (objStatus == "True") {
					status = 1;
				}

				Member newMember = new Member(fullName, age, gender, phoneNum, address, numOf_BorrBook, status);
				rep.createMember(newMember);
				dispose();
			}
		});
		btnOk.setBounds(181, 315, 89, 23);
		getContentPane().add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(280, 315, 89, 23);
		getContentPane().add(btnCancel);

		JPanel addpanel = new JPanel();
		addpanel.setBorder(new TitledBorder(null, "Input Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		addpanel.setBounds(6, 8, 363, 294);
		getContentPane().add(addpanel);
		addpanel.setLayout(null);
		{
			JLabel lblName = new JLabel("FullName : ");
			lblName.setBounds(12, 27, 53, 14);
			addpanel.add(lblName);
		}
		{
			JLabel lblAge = new JLabel("Age :");
			lblAge.setBounds(12, 69, 53, 14);
			addpanel.add(lblAge);
		}
		{
			JLabel lblAge = new JLabel("Gender :");
			lblAge.setBounds(12, 111, 53, 14);
			addpanel.add(lblAge);
		}

		JLabel lblGender = new JLabel("Address :");
		lblGender.setBounds(12, 195, 53, 14);
		addpanel.add(lblGender);

		txtPhoneNum = new JTextField();
		txtPhoneNum.setBounds(110, 150, 243, 20);
		addpanel.add(txtPhoneNum);
		txtPhoneNum.setColumns(10);

		txtfullName = new JTextField();
		txtfullName.setBounds(110, 24, 243, 20);
		addpanel.add(txtfullName);
		txtfullName.setColumns(10);
		{
			JLabel lblAddress = new JLabel("PhoneNum :");
			lblAddress.setBounds(12, 153, 64, 14);
			addpanel.add(lblAddress);
		}

		txtAge = new JTextField();
		txtAge.setBounds(110, 66, 243, 20);
		addpanel.add(txtAge);
		txtAge.setColumns(10);

		txtAddress = new JTextField();
		txtAddress.setBounds(110, 192, 243, 20);
		addpanel.add(txtAddress);
		txtAddress.setColumns(10);

		JComboBox cbGender = new JComboBox();
		cbGender.setBounds(110, 108, 93, 20);
		cbGender.addItem("Male");
		cbGender.addItem("Female");
		addpanel.add(cbGender);

		JLabel lblNumofborrbook = new JLabel("NumOf_BorrBook : ");
		lblNumofborrbook.setBounds(12, 234, 93, 14);
		addpanel.add(lblNumofborrbook);

		txtNumOf = new JTextField();
		txtNumOf.setBounds(110, 231, 243, 20);
		addpanel.add(txtNumOf);
		txtNumOf.setColumns(10);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setBounds(12, 265, 46, 14);
		addpanel.add(lblStatus);

		JComboBox cbStatus = new JComboBox();
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "True", "False" }));
		cbStatus.setBounds(110, 262, 93, 20);
		addpanel.add(cbStatus);

	}

	class MyComboBox extends JComboBox {
		public MyComboBox() {
			addItem("Male");
			addItem("Female");
		}
	}

}
