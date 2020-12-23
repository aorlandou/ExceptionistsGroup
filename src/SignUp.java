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
		nameText.setBounds(100, 20, 165, 25);
		panel.add(nameText);

		surnameLabel = new JLabel("Surname:");
		surnameLabel.setBounds(10, 50, 800, 25);
		panel.add(surnameLabel);
		surnameText = new JTextField();
		surnameText.setBounds(100, 50, 165, 25);
		panel.add(surnameText);

		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 80, 800, 25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 80, 165, 25);
		panel.add(passwordText);

		phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 110, 800, 25);
		panel.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(100, 110, 165, 25);
		panel.add(phoneText);

		genderLabel = new JLabel("Gender:");
		genderLabel.setBounds(10, 140, 800, 25);
		panel.add(genderLabel);
		genderText = new JTextField();
		genderText.setBounds(100, 140, 165, 25);
		panel.add(genderText);

		birthdateLabel = new JLabel("Birthdate:");
		birthdateLabel.setBounds(10, 170, 800, 25);
		panel.add(birthdateLabel);
		birthdateText = new JTextField();
		birthdateText.setBounds(100, 170, 165, 25);
		panel.add(birthdateText);

		municipalityLabel = new JLabel("Municipality:");
		municipalityLabel.setBounds(10, 200, 800, 25);
		panel.add(municipalityLabel);
		municipalityText = new JTextField();
		municipalityText.setBounds(100, 200, 165, 25);
		panel.add(municipalityText);
		
		button = new JButton("Sign up");
		button.setBounds(10, 300 , 100, 65);
		button.addActionListener(new SignUp());
		panel.add(button);

		frame.setVisible(true);

	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = nameText.getText();
		String password = passwordText.getText();
		String surname = surnameText.getText();
		String phone = phoneText.getText();
		String birthdate = birthdateText.getText();
		String gender = genderText.getText();
		String municipality = municipalityText.getText();
		
		JFrame frame2 = new JFrame();
		JPanel panel2 = new JPanel();
		frame2.setSize(600, 300);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame2.add(panel2);
		frame2.setVisible(true);
		panel2.setLayout(null);
		button = new JButton("Confirm");
		button.setBounds(240, 100 , 100, 35);
		button.addActionListener(new SignUp());
		panel2.add(button);

		do {
			password2Label = new JLabel("Please enter your password again to confirm:");
			password2Label.setBounds(10, 20, 700, 15);
			panel2.add(password2Label);
			password2Text = new JPasswordField();
			password2Text.setBounds(280, 20, 165, 25);
			panel2.add(password2Text);
			}while (!password2Text.equals(passwordText));
		
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