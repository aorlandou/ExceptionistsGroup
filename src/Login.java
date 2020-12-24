import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Color;

public class Login implements ActionListener  {

	private static JLabel phoneLabel;
	private static JTextField phoneText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton btnEnter;
	private static JLabel success;
	private static int count = 0; //counts how many trials user has done to login

	//Method for login
	/**
	 * @wbp.parser.entryPoint
	 */
	public void loginmethod() {

		JFrame frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		JPanel panel = new JPanel();
		frmLogin.setSize(393, 221);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);

		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);

		//FOR THE PHONENUMBER
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 15, 800, 34);
		panel.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(100, 20, 165, 25);
		panel.add(phoneText);

		//FOR THE PASSWORD
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 43, 800, 38);
		panel.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		btnEnter = new JButton("Enter");
		btnEnter.setBackground(Color.LIGHT_GRAY);
		btnEnter.setBounds(137, 92 , 97, 37);
		btnEnter.addActionListener(new Login());
		panel.add(btnEnter);

		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);

		frmLogin.setVisible(true);
		this.count++; //increase the trials of login into account
	}

	//method getCount
	public int getCount() {
		return count;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		DB dbObject = new DB(); // create DB object
		String phone = phoneText.getText();
		String password = passwordText.getText();
		String answer = dbObject.getPassword(phone);

		if (answer.equals("nothing returned")) {
			success.setText("Sorry, this phonenumber does not exist");
			//return in Main !! PROBLEM
			Main back = new Main();
			back.main(null);
		} else if (password.contentEquals(answer)) { //if phone exists in DB and password is also correct
			success.setText("LOGIN SUCCESSFUL");
			createCurrentAccount(phone);
			Main m = new Main();
			m.closeW();
		} else if (!password.contentEquals(answer)) {
			success.setText("Your password is incorrect");
			success.setText("Please enter valid data");
				if (getCount() <= 3 ) {
					loginmethod();
				} else {
					success.setText("Sorry you can not login");
					success.setText("Try again later");
					System.exit(0);
				}
		}
	}

	// Method that creates the current account
	/**
	 * @wbp.parser.entryPoint
	 */
	public void createCurrentAccount(String phone) {
		DB db = new DB(); // create DB object
		String name = db.getName(phone);
		String surname = db.getSurname(phone);
		String password = db.getPassword(phone);
		String birthday = db.getBirthdate(phone);
		String gender = db.getGender(phone);
		String municipality = db.getMunicipality(phone);
		Account currentAccount = new Account(name, surname, password, phone, birthday, gender, municipality);
		// The constructor of class Account that we have created is called
		List<String> friends = new ArrayList<String>(); // List in which user's friends are saved
		friends = db.getFriends(phone);
		List<String> notifications = new ArrayList<String>(); // List in which user's notifications are saved
		notifications = db.getNotifications(phone);
		currentAccount.setNotifications(notifications);
		currentAccount.setFriends(friends);
		String covidState = db.getState(phone); // returns yes if user has covid /  no if user hasn't covid

		if (covidState != null) { // this means that user has already inserted his covidState
			currentAccount.setCovidState(covidState); // call of method setCovidState so that to save user's state
		}
		MainMenuGUI mainMenu = new MainMenuGUI(currentAccount); // create MainMenu object
		mainMenu.setVisible(true);

	}
}
