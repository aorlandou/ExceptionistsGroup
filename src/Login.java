import java.util.Scanner;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Login {

	public void loginmethod() throws InputMismatchException {
		DB dbObject = new DB(); // create DB object
		Scanner sc = new Scanner(System.in); // Scanner object sc
		try {
			String phone=JOptionPane.showInputDialog("Please enter your phonenumber");
			
			String answer = dbObject.getPassword(phone);

			if (answer.equals("nothing returned")) { // phone doesn't exist in the system
				System.out.println("Sorry but this phonenumber does not exists");
				sc.close();
				return; // User is returned in previous method
			} else { // phone exists / continue process
				boolean validpass; // validpass returns if user has entered a valid password
				validpass = findPassword(answer); // call control method
				if (validpass == true) { // user has typed valid password
					System.out.println("You are connecting to your account");
					createCurrentAccount(phone);
					// go to main menu
				} else { // user can not login to the system
					System.out.println("Sorry you can not login \n Try again later");
					// PROBLEM/system.exit? !!!
				}
			} // end else/ end procedure of login
		} catch (InputMismatchException e) {
			sc.nextInt();
			System.err.printf("\n Exception: %s \n", e);
			System.out.println("Invalid data \n Try again");
		} // end catch
		sc.close();
	} // end of passwordControl method

	public boolean findPassword(String ans) {
		Scanner sc = new Scanner(System.in); // Scanner object sc
		String tryAgain = "yes"; // user enters yes/no do that to enter again his password
		// We initialize the variable with "yes" so that the loop will be realized at
		// least once
		int count = 0; // count user's trials
		String password; // user's password is expected
		boolean found = false; // We examine if user has succeeded to login
		while (tryAgain.equals("yes") && count < 5) { // only 5 times user can try to type his password
			password=JOptionPane.showInputDialog("Please enter your password");// user enters again the password
			count++;
			if (!ans.equals(password)) { // not valid password
				System.out.println("Sorry but your password in not correct");
				if (count < 5) {
					System.out.println("Do you want to try again? (yes/no). You have " + (5 - count) + " tries left.");
					tryAgain = sc.next();
				} else {
					System.out.println("No more trials");
					break;
				} // end else

				if (tryAgain.equals("no")) {
					break; // PROBLEM / system.exit? !!!
				}

			} else { // valid password is entered
				found = true; // user can login
				break;
			}

		} // end while
		sc.close();
		return found;
	} // end of control method

	// Method that creates the current account
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
		String covidState = db.getState(phone); // returns yes if user has covid/ no if user hasn't covid
		if (covidState != null) { // this means that user has already inserted his covidState
			currentAccount.setCovidState(covidState); // call of method setCovidState so that to save user's state
		}
		MainMenu mainMenu = new MainMenu(currentAccount); // create MainMenu object
		mainMenu.printMenu();

	}

}