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
		
		setTitle("Complete the fields");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Name :");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 0);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 1;
		gbc_nameField.gridy = 0;
		contentPane.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		surnameField = new JTextField();
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.insets = new Insets(0, 0, 5, 0);
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.gridx = 1;
		gbc_surnameField.gridy = 1;
		contentPane.add(surnameField, gbc_surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		pass1Field = new JPasswordField();
		GridBagConstraints gbc_pass1Field = new GridBagConstraints();
		gbc_pass1Field.insets = new Insets(0, 0, 5, 0);
		gbc_pass1Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_pass1Field.gridx = 1;
		gbc_pass1Field.gridy = 2;
		contentPane.add(pass1Field, gbc_pass1Field);
		pass1Field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password :");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		pass2Field = new JPasswordField();
		pass2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validatePassword();
			}
		});
		GridBagConstraints gbc_pass2Field = new GridBagConstraints();
		gbc_pass2Field.insets = new Insets(0, 0, 5, 0);
		gbc_pass2Field.fill = GridBagConstraints.HORIZONTAL;
		gbc_pass2Field.gridx = 1;
		gbc_pass2Field.gridy = 3;
		contentPane.add(pass2Field, gbc_pass2Field);
		pass2Field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone :");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		phoneField = new JTextField();
		GridBagConstraints gbc_phoneField = new GridBagConstraints();
		gbc_phoneField.insets = new Insets(0, 0, 5, 0);
		gbc_phoneField.fill = GridBagConstraints.HORIZONTAL;
		gbc_phoneField.gridx = 1;
		gbc_phoneField.gridy = 4;
		contentPane.add(phoneField, gbc_phoneField);
		phoneField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender :");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		genderField = new JTextField();
		GridBagConstraints gbc_genderField = new GridBagConstraints();
		gbc_genderField.insets = new Insets(0, 0, 5, 0);
		gbc_genderField.fill = GridBagConstraints.HORIZONTAL;
		gbc_genderField.gridx = 1;
		gbc_genderField.gridy = 5;
		contentPane.add(genderField, gbc_genderField);
		genderField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Birthdate :");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		bdateField = new JTextField();
		GridBagConstraints gbc_bdateField = new GridBagConstraints();
		gbc_bdateField.insets = new Insets(0, 0, 5, 0);
		gbc_bdateField.fill = GridBagConstraints.HORIZONTAL;
		gbc_bdateField.gridx = 1;
		gbc_bdateField.gridy = 6;
		contentPane.add(bdateField, gbc_bdateField);
		bdateField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Municipality :");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		municField = new JTextField();
		GridBagConstraints gbc_municField = new GridBagConstraints();
		gbc_municField.insets = new Insets(0, 0, 5, 0);
		gbc_municField.fill = GridBagConstraints.HORIZONTAL;
		gbc_municField.gridx = 1;
		gbc_municField.gridy = 7;
		contentPane.add(municField, gbc_municField);
		municField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign Up");
		
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
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
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
