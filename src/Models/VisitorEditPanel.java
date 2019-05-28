package Models;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VisitorEditPanel extends JDialog {
	private JTextField txtName;
	private JTextField txtAddress;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VisitorEditPanel dialog = new VisitorEditPanel();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VisitorEditPanel() {
		setTitle("Edit Visitor");
		setBounds(100, 100, 397, 329);
		getContentPane().setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name : ");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel.setBounds(10, 41, 70, 17);
			getContentPane().add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Address :");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_1.setBounds(10, 69, 70, 17);
			getContentPane().add(lblNewLabel_1);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Phone :");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_2.setBounds(10, 97, 70, 20);
			getContentPane().add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Age :");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_3.setBounds(10, 128, 70, 20);
			getContentPane().add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Gender : ");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNewLabel_4.setBounds(10, 159, 70, 20);
			getContentPane().add(lblNewLabel_4);
		}
		{
			txtName = new JTextField();
			txtName.setBounds(78, 40, 283, 20);
			getContentPane().add(txtName);
			txtName.setColumns(10);
		}
		{
			txtAddress = new JTextField();
			txtAddress.setBounds(78, 68, 283, 20);
			getContentPane().add(txtAddress);
			txtAddress.setColumns(10);
		}
		{
			textField = new JTextField();
			textField.setBounds(78, 97, 283, 20);
			getContentPane().add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(78, 129, 283, 20);
			getContentPane().add(textField_1);
			textField_1.setColumns(10);
		}

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(78, 160, 91, 20);
		getContentPane().add(comboBox);

		JLabel lblIsMember = new JLabel("Is Member: ");
		lblIsMember.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIsMember.setBounds(10, 190, 70, 20);
		getContentPane().add(lblIsMember);

		JRadioButton rdbtnTrue = new JRadioButton("True");
		rdbtnTrue.setBounds(88, 190, 60, 23);
		getContentPane().add(rdbtnTrue);

		JRadioButton rdbtnFalse = new JRadioButton("False");
		rdbtnFalse.setBounds(150, 190, 60, 23);
		getContentPane().add(rdbtnFalse);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setBounds(121, 244, 89, 23);
		getContentPane().add(btnOk);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(236, 244, 89, 23);
		getContentPane().add(btnCancel);

		JLabel lblInputInfomation = new JLabel("INPUT INFOMATION");
		lblInputInfomation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInputInfomation.setBounds(150, 11, 197, 19);
		getContentPane().add(lblInputInfomation);
	}
}
