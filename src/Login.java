import java.util.Scanner;
import java.util.InputMismatchException;

public class Login {

	public void passwordControl() throws InputMismatchException {
		DB dbObject = new DB(); //create DB object
		Scanner sc = new Scanner(System.in); //Scanner object sc
		try {
			System.out.println("Please enter your phonenumber");
			String phone = sc.next();
			String answer = dbObject.getPassword(phone);
			
				if (answer.equals("nothing returned")) {
					System.out.println("Sorry but this phonenumber does not exists \n Back in menu");
					return;
				} else {
					System.out.println("Please enter your password");
					String password = sc.next(); //user's password is expected
					
					answer = dbObject.getPassword(phone); //valid password from database is returned
					control(answer, password, phone); //call control method
				}// end else/ Procedure of getting the password from the user

		} catch(InputMismatchException e) {
			sc.nextInt();
			System.err.printf("\n Exception: %s \n", e);
			System.out.println("Invalid data \n Try again");
		} //end catch
	} //end of passwordControl method

	public void control(String ans, String password, String phone) {
		Scanner sc = new Scanner(System.in); //Scanner object sc
		String tryAgain; //user enters yes/no do that to enter again his password
		int count = 0; 
		if (! ans.equals(password)) { //password from database doesn't match with the password, which user has typed
			System.out.println("Sorry but your password in not correct");
			System.out.println("Do you want to try again? (yes/no)");
			tryAgain = sc.next();
			count++; //increase trials
			
			if (tryAgain.equals("no")){ //User doesn't want to try again
				System.out.println("Back in menu");
			}

			while (tryAgain.equals("yes") && count < 5) {  //only 5 times user can try to type his password
				password = sc.next(); //user enters again the password
				if (! ans.equals(password)) { //not valid password
					count++;
					System.out.println("Sorry but your password in not correct");
					System.out.println("Do you want to try again? (yes/no)");
					tryAgain = sc.next();
				} else { //Now user can login
					createCurrentAccount(phone);
					break;
				}
			} //end while
		} else { //Now user can login
			createCurrentAccount(phone);
		}
	} //end of control method
	
	//Method that creates the current account
	public void createCurrentAccount(String phone) {
		DB db = new DB(); //create DB object
		String name = db.getName(phone);
		String surname = db.getSurname(phone);
		String password = db.getPassword(phone);
		String birthday = db.getBirthdate(phone);
		String gender = db.getGender(phone);
		String municipality = db.getMunicipality(phone);
		
		//The constructor of class Account is called 
		Account currentAccount = new Account(name, surname, password, phone, birthday, gender, municipality);
		//Print main menu
	}
	
	
}