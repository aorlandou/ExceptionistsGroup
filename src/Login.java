import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JLabel phoneLabel;
	private  JTextField phoneText;
	private JLabel passwordLabel;
	private JPasswordField passwordText;
	private JButton btnEnter;
	
	
	public Login() {
		setTitle("Login");
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 389, 229);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		//FOR THE PHONENUMBER
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setForeground(SystemColor.activeCaption);
		phoneLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		phoneLabel.setBounds(10, 20, 800, 29);
		contentPane.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(100, 20, 165, 29);
		contentPane.add(phoneText);

		//FOR THE PASSWORD
		passwordLabel = new JLabel("Password:");
		passwordLabel.setForeground(SystemColor.activeCaption);
		passwordLabel.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		passwordLabel.setBounds(10, 52, 800, 29);
		contentPane.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 52, 165, 29);
		contentPane.add(passwordText);

		btnEnter = new JButton("Enter");
		btnEnter.setForeground(Color.WHITE);
		btnEnter.setFont(new Font("Eras Bold ITC", Font.BOLD, 14));
		btnEnter.setBackground(Color.GRAY);
		btnEnter.setBounds(134, 106 , 97, 37);
		contentPane.add(btnEnter);

	}
	
	public void login() {
	btnEnter.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
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
			closeWin();
		} else if (password.contentEquals(answer)) { //if phone exists in DB and password is also correct
			
			createCurrentAccount(phone);
			Main m = new Main();
			closeWin();
		} else if (!password.contentEquals(answer)) {
			try {
				JOptionPane.showMessageDialog(null, "Your password is wrong");
				
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, ex);
			}
	   }
	}
	
	});
  }
		

	private void closeWin() {
		WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	}
	
	
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


