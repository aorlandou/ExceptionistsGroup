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
import java.awt.event.WindowEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignUpwithgraphics extends JFrame {


	private  JPanel contentPane;
	private  JTextField nameField;
	private  JTextField surnameField;
	private  JPasswordField pass1Field;
	private  JPasswordField pass2Field;
	private  JTextField phoneField;
	private  JTextField bdateField;
	

	/**
	 * Create the frame.
	 */
	public SignUpwithgraphics() {
		
		setTitle("Sign Up ");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 447);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setForeground(new Color(176, 196, 222));
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 12, 152, 31);

		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		nameField.setBackground(new Color(211, 211, 211));
		nameField.setBounds(165, 11, 218, 31);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setForeground(new Color(176, 196, 222));
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));

		lblNewLabel_1.setBounds(10, 53, 152, 31);
		contentPane.add(lblNewLabel_1);
		
		surnameField = new JTextField();
		surnameField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		surnameField.setBackground(new Color(211, 211, 211));
		surnameField.setBounds(165, 54, 218, 31);
		contentPane.add(surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(new Color(176, 196, 222));
		lblNewLabel_2.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));

		lblNewLabel_2.setBounds(10, 95, 152, 31);

		contentPane.add(lblNewLabel_2);
		
		pass1Field = new JPasswordField();
		pass1Field.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pass1Field.setBackground(new Color(211, 211, 211));
		pass1Field.setBounds(165, 96, 218, 31);
		contentPane.add(pass1Field);
		pass1Field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password :");
		lblNewLabel_3.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(176, 196, 222));

		lblNewLabel_3.setBounds(10, 137, 152, 31);
		contentPane.add(lblNewLabel_3);
		
		pass2Field = new JPasswordField();
		pass2Field.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		pass2Field.setBackground(new Color(211, 211, 211));
		pass2Field.setBounds(165, 138, 218, 31);

		pass2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validatePassword();
			}
		});
		contentPane.add(pass2Field);
		pass2Field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone :");
		lblNewLabel_4.setForeground(new Color(176, 196, 222));
		lblNewLabel_4.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 179, 152, 31);
		contentPane.add(lblNewLabel_4);
		
		phoneField = new JTextField();
		phoneField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		phoneField.setBackground(new Color(211, 211, 211));
		phoneField.setBounds(165, 180, 218, 31);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender :");
		lblNewLabel_5.setForeground(new Color(176, 196, 222));
		lblNewLabel_5.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 221, 152, 31);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Birthdate :");
		lblNewLabel_6.setForeground(new Color(176, 196, 222));
		lblNewLabel_6.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 262, 152, 31);
		contentPane.add(lblNewLabel_6);
		
		bdateField = new JTextField();
		bdateField.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		bdateField.setBackground(new Color(211, 211, 211));
		bdateField.setBounds(165, 263, 218, 31);
		contentPane.add(bdateField);
		bdateField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Municipality :");
		lblNewLabel_7.setForeground(new Color(176, 196, 222));
		lblNewLabel_7.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 303, 152, 31);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Create ");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setForeground(new Color(248, 248, 255));
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.BOLD, 17));
		btnNewButton.setBounds(175, 346, 135, 40);
		
		JComboBox genderbox = new JComboBox();
		genderbox.setBackground(new Color(211, 211, 211));
		genderbox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		genderbox.setForeground(new Color(0, 0, 0));
		genderbox.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));
		genderbox.setSelectedIndex(2);
		genderbox.setToolTipText("");

		genderbox.setBounds(165, 221, 100, 31);

		contentPane.add(genderbox);
        contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		comboBox.setBackground(new Color(211, 211, 211));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Acharnes", "Aegina", "Agia Paraskevi",
				"Agia Varvara", "Agioi Anargyroi-Kamatero", "Agios Dimitrios", "Agistri", "Aigaleo", "Alimos", 
				"Aspropyrgos", "Chalandri ", "Dafni-Ymittos", "Dionysos", "Eleusis", "Elliniko-Argyroupoli",
				"Filadelfeia-Chalkidona", "Filothei-Psychiko", "Fyli", "Galatsi", "Glyfada", "Haidari", "Hydra", 
				"Ilion", "Ilioupoli", "Irakleio", "Kaisariani", "Kallithea", "Keratsini-Drapetsona", "Kifissia", 
				"Korydallos", "Kropia", "Kythira", "Lavreotiki", "Lykovrysi-Pefki", "Mandra-Eidyllia", 
				"Markopoulo Mesogaias", "Marousi", "Megara", "Metamorfosi","Moschato-Tavros", 
				"Nea Ionia", "Nea Smyrni", "Nikaia-Agios Ioannis Rentis", "Oropos", "Paiania", "Palaio Faliro", 
				"Pallini", "Papagou-Cholargos", "Penteli", "Perama", "Peristeri", "Petroupoli", "Piraeus", 
				"Rafina-Pikermi", "Salamis ", "Saronikos", "Spata-Artemida", "Spetses", "Troizinia-Methana", 
				"Vari-Voula-Vouliagmeni", "Vrilissia", "Vyronas", "Zografou"}));
		comboBox.setBounds(165, 304, 218, 31);
		contentPane.add(comboBox);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(validateParam() == false && validatePassword() == false) {
					String name = nameField.getText();
					String surname = surnameField.getText();
					String password = pass1Field.getText();
					String password2 = pass2Field.getText();
					String phone = phoneField.getText();
					String birthdate = bdateField.getText();
					String gender = (String)genderbox.getSelectedItem();
					String municipality = (String)comboBox.getSelectedItem();
					
					Account user = new Account(name, surname, password, phone, birthdate, gender, municipality);
					
					DB data = new DB();
					try {
						data.insertAcc(user);
					} catch (Exception en) {
						en.printStackTrace();
					}
					closeWin();
					MainMenuGUI mainMenu = new MainMenuGUI(user); // create MainMenu object
					mainMenu.setVisible(true);
				}
			}
		});
		
		
	}
	private void closeWin() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	private void String(JTextField textField_72) {
		// TODO Auto-generated method stub
		
	}

	public boolean validateParam() {
		String name = nameField.getText();
		String surname = surnameField.getText();
		String password = pass1Field.getText();
		String phone = phoneField.getText();
		boolean t = false;
		if (name.equals("")) {
			JOptionPane.showMessageDialog(null, "Name can't be empty.");
			t = true;
		}
		if (surname.equals("")) {
			JOptionPane.showMessageDialog(null, "Surname can't be empty.");
			t = true;
		}
		if (password.equals("")) {
			JOptionPane.showMessageDialog(null, "Password can't be empty.");
			t = true;
		}
		if (phone.equals("")) {
			JOptionPane.showMessageDialog(null, "Phone can't be empty.");
			t = true;
		}
		return t;
	}

	public boolean validatePassword() {
		String password = pass1Field.getText();
		String password2 = pass2Field.getText();
		boolean v = false;
		if (!password.contentEquals(password2)) {
			JOptionPane.showMessageDialog(this, "The password doesn't match.\n Please try again.");
			v = true;
		}
		return v;
	}
}
