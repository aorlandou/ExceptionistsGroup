import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

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
		frmLogin.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmLogin.setTitle("Login");
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		frmLogin.setSize(372, 211);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);

		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);

		//FOR THE PHONENUMBER
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setForeground(SystemColor.activeCaption);
		phoneLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		phoneLabel.setBounds(10, 20, 800, 29);
		panel.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(100, 20, 165, 29);
		panel.add(phoneText);

		//FOR THE PASSWORD
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(SystemColor.activeCaption);
		passwordLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		passwordLabel.setBounds(10, 52, 800, 29);
		panel.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 52, 165, 29);
		panel.add(passwordText);

		btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		btnEnter.setBackground(Color.GRAY);
		btnEnter.setBounds(133, 98 , 97, 37);
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
			try {
				JOptionPane.showMessageDialog(null, "This phone number doesn't exist");
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
			Main back = new Main();
			back.main(null);
		} else if (password.contentEquals(answer)) { //if phone exists in DB and password is also correct
			
			createCurrentAccount(phone);
			Main m = new Main();
			m.closeW();
		} else if (!password.contentEquals(answer)) {
			try {
				JOptionPane.showMessageDialog(null, "Your password is wrong");
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
				if (getCount() <= 3 ) {
					loginmethod();
				} else {
					try {
						JOptionPane.showMessageDialog(null, "Sorry you can not login.Try again later");
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
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
