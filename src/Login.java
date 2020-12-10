import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener  {

<<<<<<< Updated upstream
	private static JLabel phoneLabel;
	private static JTextField phoneText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	private int count = 0; //counts how many trials user has done to login

	public void loginmethod() { //method using GUI for the login procedure
=======
	public static void loginmethod() throws InputMismatchException {
		DB dbObject = new DB(); //create DB object
		Scanner sc = new Scanner(System.in); //Scanner object sc
		try {
			System.out.println("Please enter your phonenumber");
			String phone = sc.next();
			String answer = dbObject.getPassword(phone);
			
				if (answer.equals("nothing returned")) { //phone doesn't exist in the system
					System.out.println("Sorry but this phonenumber does not exists \n Back in menu");
					return; //User is returned in previous method
				} else { //phone exists / continue process
					boolean validpass; // validpass returns if user has entered a valid password
					validpass = findPassword(answer); //call control method
					if (validpass == true) { //user has typed valid password
						System.out.println("You are connecting to your account");
						createCurrentAccount(phone);
						//go to main menu
					} else { //user can not login to the system
						System.out.println("Sorry you can not login \n Try again later");
						//PROBLEM/system.exit? !!!
					}
				}// end else/ end procedure of login
		} catch(InputMismatchException e) {
			sc.nextInt();
			System.err.printf("\n Exception: %s \n", e);
			System.out.println("Invalid data \n Try again");
		} //end catch
		sc.close();
	} //end of passwordControl method

	public static boolean findPassword(String ans) {
		Scanner sc = new Scanner(System.in); //Scanner object sc
		String tryAgain = "yes"; //user enters yes/no do that to enter again his password
		//We initialize the variable with "yes" so that the loop will be realized at least once
		int count = 0; //count user's trials
		String password; //user's password is expected
		boolean found = false; //We examine if user has succeeded to login
			while (tryAgain.equals("yes") && count < 5) {  //only 5 times user can try to type his password
				System.out.println("Please enter your password");
				password = sc.next(); //user enters again the password
				count++;
				if (! ans.equals(password)) { //not valid password
					System.out.println("Sorry but your password in not correct");
						if (count < 5) {
						System.out.println("Do you want to try again? (yes/no). You have " + (5-count) + " tries left.");
						tryAgain = sc.next();
						} else {
							System.out.println("No more trials");
							break;
						}//end else
>>>>>>> Stashed changes

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		frame.setSize(350, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(panel);
		panel.setLayout(null);

		//FOR THE PHONENUMBER
		phoneLabel = new JLabel("Phone:");
		phoneLabel.setBounds(10, 20, 800, 25);
		panel.add(phoneLabel);
		phoneText = new JTextField();
		phoneText.setBounds(100, 20, 165, 25);
		panel.add(phoneText);

		//FOR THE PASSWORD
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 50, 800, 25);
		panel.add(passwordLabel);
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 50, 165, 25);
		panel.add(passwordText);

		button = new JButton("Login");
		button.setBounds(10, 80 , 80, 25);
		button.addActionListener(new Login());
		panel.add(button);

		success = new JLabel("");
		success.setBounds(10, 110, 300, 25);
		panel.add(success);
		
		frame.setVisible(true);
		count++;
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
			return;
		} else if (password.contentEquals(answer)) { //if phone exists in DB and password is also correct
			success.setText("LOGIN SUCCESSFUL");
			createCurrentAccount(phone);
		} else if (!password.contentEquals(answer)) {
			success.setText("Your password is incorrect");
			success.setText("Please enter valid data");
				if (getCount() <= 3) {
					loginmethod();
				} else {
					success.setText("Sorry you can not login");
					success.setText("Try again later");
					System.exit(0);
				}
		}
	}

<<<<<<< Updated upstream
	// Method that creates the current account
	public void createCurrentAccount(String phone) {
		DB db = new DB(); // create DB object
=======
	//Method that creates the current account
	public static void createCurrentAccount(String phone) {
		DB db = new DB(); //create DB object
>>>>>>> Stashed changes
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
		String covidState = db.getState(phone); // returns yes if user has covid/ no if user hasn't covid
		if (covidState != null) { // this means that user has already inserted his covidState
			currentAccount.setCovidState(covidState); // call of method setCovidState so that to save user's state
		}
		MainMenu mainMenu = new MainMenu(currentAccount); // create MainMenu object
		mainMenu.printMenu();
	}
}