
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignUp implements ActionListener{
	
	private static JLabel nameLabel;
	private static JTextField nameText;
	private static JLabel surnameLabel;
	private static JTextField surnameText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JLabel password2Label;
	private static JPasswordField password2Text;
	private static JLabel phoneLabel;
	private static JTextField phoneText;
	private static JLabel genderLabel;
	private static JTextField genderText;
	private static JLabel birthdateLabel;
	private static JTextField birthdateText;
	private static JLabel municipalityLabel;
	private static JTextField municipalityText;
	private static JButton button;
	private static JLabel success;
	
	public static void creatAccount() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);

		panel.setLayout(null);

	    nameLabel = new JLabel("Name:");
		nameLabel.setBounds(10, 20, 800, 25);
		panel.add(nameLabel);
		nameText = new JTextField();
		nameText.setBounds(150, 20, 165, 25);
		panel.add(nameText);

		surnameLabel = new JLabel("Surname:");
		surnameLabel.setBounds(10, 50, 800, 25);
		panel.add(surnameLabel);
		surnameText = new JTextField();
		surnameText.setBounds(150, 50, 165, 25);
		panel.add(surnameText);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 80, 800, 25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(150, 80, 165, 25);
		panel.add(passwordText);

		
		password2Label = new JLabel("Confirm your password:");
		password2Label.setBounds(10, 110, 800, 25);
		panel.add(password2Label);
		password2Text = new JPasswordField();
		password2Text.setBounds(150, 110, 165, 25);
		panel.add(password2Text);
		

		phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 140, 800, 25);
		panel.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(150, 140, 165, 25);
		panel.add(phoneText);

		genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(10, 170, 800, 25);
		panel.add(genderLabel);
		genderText = new JTextField();
		genderText.setBounds(150, 170, 165, 25);
		panel.add(genderText);

		birthdateLabel = new JLabel("Birthdate:");
		birthdateLabel.setBounds(10, 200, 800, 25);
		panel.add(birthdateLabel);
		birthdateText = new JTextField();
		birthdateText.setBounds(150, 200, 165, 25);
		panel.add(birthdateText);

		municipalityLabel = new JLabel("Municipality:");
		municipalityLabel.setBounds(10, 230, 800, 25);
		panel.add(municipalityLabel);
		municipalityText = new JTextField();
		municipalityText.setBounds(150, 230, 165, 25);
		panel.add(municipalityText);
		
		button = new JButton("Sign up");
		button.setBounds(10, 300 , 100, 65);
		button.addActionListener(new SignUp());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);

		frame.setVisible(true);

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameText.getText();
		String password = passwordText.getText();
		String password2 = passwordText.getText();
		String surname = surnameText.getText();
		String phone = phoneText.getText();
		String birthdate = birthdateText.getText();
		String gender = genderText.getText();
		String municipality = municipalityText.getText();
		
		if (!password2.equals(password)) {
			success.setText("Please enter again your password correctly");
			
		}else {
			success.setText("You have signed up!");
		
		Account user = new Account(name, surname, password, phone, birthdate, gender, municipality);
		
		DB data = new DB();
		try {
			data.insertAcc(user);
		} catch (Exception en) {
			en.printStackTrace();
		}

		Main w = new Main();
		w.closeW();
		MainMenuGUI mainMenu = new MainMenuGUI(user); // create MainMenu object
		mainMenu.setVisible(true);
	}
}