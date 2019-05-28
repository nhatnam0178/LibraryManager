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

import DAO.ConnectionSQL;

public class VisitorAddPanel extends JDialog {
	private JTextField txtAddress;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private JTextField txtPayment;
	private JTextField txtMemberEnd;
	private JTextField txtSerial;
	private ConnectionSQL conn;
	private JTextField txtID;
	private MyComboBox cbGender = new MyComboBox();
	private MyCheckBox IsMember = new MyCheckBox(this);

	/**
	 * Create the dialog.
	 */
	public VisitorAddPanel() {
		setTitle("Add New Visitor");
		setBounds(100, 100, 362, 414);
		getContentPane().setLayout(null);

//		JCheckBox isMember = new JCheckBox("Is Memeber");
//
//		isMember.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (isEnabled()) {
//					txtPayment.setEditable(true);
//					txtMemberEnd.setEditable(true);
//					txtSerial.setEditable(true);
//				} else {
//					txtPayment.setEditable(false);
//					txtMemberEnd.setEditable(false);
//					txtSerial.setEditable(false);
//				}
//			}
//		});
//		isMember.setBounds(6, 186, 97, 23);
//		getContentPane().add(isMember);

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
			lblName.setBounds(10, 44, 53, 14);
			addpanel.add(lblName);
		}
		{
			JLabel lblPhoneNo = new JLabel("Phone No :");
			lblPhoneNo.setBounds(10, 69, 53, 14);
			addpanel.add(lblPhoneNo);
		}
		{
			JLabel lblAge = new JLabel("Age :");
			lblAge.setBounds(10, 94, 53, 14);
			addpanel.add(lblAge);
		}

		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(10, 143, 53, 14);
		addpanel.add(lblGender);

		txtAddress = new JTextField();
		txtAddress.setBounds(73, 115, 245, 20);
		addpanel.add(txtAddress);
		txtAddress.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(73, 41, 245, 20);
		addpanel.add(txtName);
		txtName.setColumns(10);
		{
			JLabel lblAddress = new JLabel("Address :");
			lblAddress.setBounds(10, 118, 53, 14);
			addpanel.add(lblAddress);
		}

		txtPhone = new JTextField();
		txtPhone.setBounds(73, 66, 245, 20);
		addpanel.add(txtPhone);
		txtPhone.setColumns(10);

		txtAge = new JTextField();
		txtAge.setBounds(73, 91, 245, 20);
		addpanel.add(txtAge);
		txtAge.setColumns(10);

		JComboBox cbGender = new JComboBox();
		cbGender.setBounds(73, 140, 76, 20);
		cbGender.addItem("Male");
		cbGender.addItem("Female");
		addpanel.add(cbGender);

		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(10, 19, 46, 14);
		addpanel.add(lblId);

		txtID = new JTextField();
		txtID.setBounds(73, 16, 245, 20);
		addpanel.add(txtID);
		txtID.setColumns(10);

	}

	class MyComboBox extends JComboBox {
		public MyComboBox() {
			addItem("Male");
			addItem("Female");
		}
	}

	class MyCheckBox extends JCheckBox {
		public MyCheckBox(VisitorAddPanel mypanel) {
			setText("Is member");
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

			mypanel.add(panelMember);
			txtPayment.setEditable(false);
			txtMemberEnd.setEditable(false);
			txtSerial.setEditable(false);

			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (isSelected()) {
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

		}

	}

	public String PaymentValue() {
		return txtPayment.getText();
	}

	public String MemberShipEndValue() {
		return txtMemberEnd.getText();
	}

	public String SerialValue() {
		return txtSerial.getText();
	}

//	public void createAddQuery() {
//		String id = txtID.getText();
//		String name = txtName.getText();
//		String Address = txtAddress.getText();
//		String Phone = txtPhone.getText();
//		String Age = txtAge.getText();
//
//		String gen;
//		String isMember = "0";
//
//		gen = (String) cbGender.getSelectedItem();
//
//		if (Is.get) {
//			isMember = "1";
//		}
//
//		String query = "Insert into Visitor values('" + name + "','" + Address + "','" + Phone + "'," + Age + ",'" + gen
//				+ "'," + isMember + ");";
//
//		try {
//			conn.Connect();
//			Statement stat = (Statement) conn.Query(query);
//			if (!stat.execute(query)) {
//				System.out.println("ADDED HAHAHAHA !!!");
//				if (IsMember.isSelected()) {
//
//					String pay = IsMember.PaymentValue();
//					String end = IsMember.MemberShipEndValue();
//					String Serial = IsMember.SerialValue();
//
//					String Mquery = "Insert into Member values('" + Serial + "'," + pay + ",'" + end + "',0,'" + name
//							+ "','" + Address + "','" + Phone + "'," + Age + ",'" + gen + "'," + isMember + ");";
//					System.out.println(Mquery);
//					stat.execute(Mquery);
//				}
//			} else
//				System.out.println("ERROR HAPPENED !!!");
//		} catch (
//
//		SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
}
