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
		setBounds(100, 100, 494, 428);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.windowBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		contentPane.setLayout(null);

		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setForeground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 10, 152, 17);

		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.setBounds(165, 6, 183, 26);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Surname :");
		lblNewLabel_1.setForeground(SystemColor.activeCaption);
		lblNewLabel_1.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));

		lblNewLabel_1.setBounds(10, 38, 152, 17);
		contentPane.add(lblNewLabel_1);
		
		surnameField = new JTextField();
		surnameField.setBounds(165, 40, 183, 28);
		contentPane.add(surnameField);
		surnameField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setForeground(SystemColor.activeCaption);
		lblNewLabel_2.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));

		lblNewLabel_2.setBounds(10, 75, 152, 22);

		contentPane.add(lblNewLabel_2);
		
		pass1Field = new JPasswordField();
		pass1Field.setBounds(165, 73, 183, 28);
		contentPane.add(pass1Field);
		pass1Field.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm password :");
		lblNewLabel_3.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(SystemColor.activeCaption);

		lblNewLabel_3.setBounds(10, 112, 152, 17);
		contentPane.add(lblNewLabel_3);
		
		pass2Field = new JPasswordField();
		pass2Field.setBounds(165, 108, 183, 28);

		pass2Field.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				validatePassword();
			}
		});
		contentPane.add(pass2Field);
		pass2Field.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Phone :");
		lblNewLabel_4.setForeground(SystemColor.activeCaption);
		lblNewLabel_4.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 153, 83, 14);
		contentPane.add(lblNewLabel_4);
		
		phoneField = new JTextField();
		phoneField.setBounds(165, 147, 183, 28);
		contentPane.add(phoneField);
		phoneField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender :");
		lblNewLabel_5.setForeground(SystemColor.activeCaption);
		lblNewLabel_5.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(10, 192, 88, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Birthdate :");
		lblNewLabel_6.setForeground(SystemColor.activeCaption);
		lblNewLabel_6.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(10, 229, 88, 14);
		contentPane.add(lblNewLabel_6);
		
		bdateField = new JTextField();
		bdateField.setBounds(165, 223, 183, 28);
		contentPane.add(bdateField);
		bdateField.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Municipality :");
		lblNewLabel_7.setForeground(SystemColor.activeCaption);
		lblNewLabel_7.setFont(new Font("Eras Bold ITC", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(10, 264, 104, 14);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton = new JButton("Create ");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		btnNewButton.setBounds(181, 311, 135, 47);
		
		JComboBox genderbox = new JComboBox();
		genderbox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		genderbox.setForeground(new Color(0, 0, 0));
		genderbox.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male", "Other"}));
		genderbox.setToolTipText("");

		genderbox.setBounds(165, 184, 183, 30);

		contentPane.add(genderbox);
        contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"    Acharnes", "    Aegina", "    Agia Paraskevi", "    Agia Varvara", "    Agioi Anargyroi-Kamatero", "    Agios Dimitrios", "    Agistri", "    Aigaleo", "    Alimos", "    Aspropyrgos", "    Chalandri ", "    Dafni-Ymittos", "    Dionysos", "    Eleusis", "    Elliniko-Argyroupoli", "    Filadelfeia-Chalkidona", "    Filothei-Psychiko", "    Fyli", "    Galatsi", "    Glyfada", "    Haidari", "    Hydra", "    Ilion", "    Ilioupoli", "    Irakleio", "    Kaisariani", "    Kallithea", "    Keratsini-Drapetsona", "    Kifissia", "    Korydallos", "    Kropia", "    Kythira", "    Lavreotiki", "    Lykovrysi-Pefki", "    Mandra-Eidyllia", "    Markopoulo Mesogaias", "    Marousi", "    Megara", "    Metamorfosi", "    Moschato-Tavros", "    Nea Ionia", "    Nea Smyrni", "    Nikaia-Agios Ioannis Rentis", "    Oropos", "    Paiania", "    Palaio Faliro", "    Pallini", "    Papagou-Cholargos", "    Penteli", "    Perama", "    Peristeri", "    Petroupoli", "    Piraeus", "    Rafina-Pikermi", "    Salamis ", "    Saronikos", "    Spata-Artemida", "    Spetses", "    Troizinia-Methana", "    Vari-Voula-Vouliagmeni", "    Vrilissia", "    Vyronas", "    Zografou"}));
		comboBox.setBounds(165, 262, 183, 28);
		contentPane.add(comboBox);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		});
		
		
	}
	private void closeWin() {
		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
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
