import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Font;

public class SignUpwithgraphics extends JFrame {


	private  JPanel contentPane;
	private  JTextField nameField;
	private  JTextField surnameField;
	private  JPasswordField pass1Field;
	private  JPasswordField pass2Field;
	private  JTextField phoneField;
	private  JTextField genderField;
	private  JTextField bdateField;
	private  JTextField municField;
	

	/**
	 * Create the frame.
	 */
	public SignUpwithgraphics() {
		
		setTitle("Register Form");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblNewLabel.setBounds(51, 6, 42, 17);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(103, 5, 269, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(36, 33, 62, 17);
		contentPane.add(lblNewLabel_1);
		
		surnameField = new JTextField();
		surnameField.setBounds(103, 30, 326, 20);
		contentPane.add(surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(45, 58, 53, 14);
		contentPane.add(lblNewLabel_2);
		
		pass1Field = new JPasswordField();
		pass1Field.setBounds(103, 55, 326, 20);
		contentPane.add(pass1Field);
		pass1Field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password :");
		lblNewLabel_3.setBounds(5, 83, 93, 14);
		contentPane.add(lblNewLabel_3);
		
		pass2Field = new JPasswordField();
		pass2Field.setBounds(103, 80, 326, 20);
		pass2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validatePassword();
			}
		});
		contentPane.add(pass2Field);
		pass2Field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone :");
		lblNewLabel_4.setBounds(61, 108, 37, 14);
		contentPane.add(lblNewLabel_4);
		
		phoneField = new JTextField();
		phoneField.setBounds(103, 105, 326, 20);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender :");
		lblNewLabel_5.setBounds(56, 133, 42, 14);
		contentPane.add(lblNewLabel_5);
		
		genderField = new JTextField();
		genderField.setBounds(103, 130, 326, 20);
		contentPane.add(genderField);
		genderField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Birthdate :");
		lblNewLabel_6.setBounds(47, 158, 51, 14);
		contentPane.add(lblNewLabel_6);
		
		bdateField = new JTextField();
		bdateField.setBounds(103, 155, 326, 20);
		contentPane.add(bdateField);
		bdateField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Municipality :");
		lblNewLabel_7.setBounds(36, 183, 62, 14);
		contentPane.add(lblNewLabel_7);
		
		municField = new JTextField();
		municField.setBounds(103, 180, 326, 20);
		contentPane.add(municField);
		municField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.setBounds(181, 244, 69, 23);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = nameField.getText();
				String surname = surnameField.getText();
				String password = pass1Field.getText();
				String password2 = pass2Field.getText();
				String phone = phoneField.getText();
				String birthdate = bdateField.getText();
				String gender = genderField.getText();
				String municipality = municField.getText();
				Account user = new Account(name, surname, password, phone, birthdate, gender, municipality);
				
				DB data = new DB();
				try {
					data.insertAcc(user);
				} catch (Exception en) {
					en.printStackTrace();
				}
				Main m = new Main();
				m.closeW();
				MainMenuGUI mainMenu = new MainMenuGUI(user); // create MainMenu object
				mainMenu.setVisible(true);
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(btnNewButton);
	}
	
	private void String(JTextField textField_72) {
		// TODO Auto-generated method stub
		
	}

public void validatePassword() {
	String password = pass1Field.getText();
	String password2 = pass2Field.getText();
	if (!password.contentEquals(password2)) {
		JOptionPane.showMessageDialog(this,"Please enter your password correclty");
	}
}
}
