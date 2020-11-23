
import java.util.Scanner;

public class SignUp {
	public static void creatAccount() {
			// TODO Auto-generated method stub
			System.out.println("Please enter your name, your surname and your password");
			Scanner scanner = new Scanner(System.in);
			String name, surname, password; 
			name = scanner.nextLine();
			surname = scanner.nextLine();
			password = scanner.nextLine();
			String password2;
				do {
					System.out.println("Please enter your password again to confirm");
					password2 = scanner.nextLine();
				}
				while (!password2.equals(password)); 
		System.out.println("Please enter your phone number, your gender, your birthdate and your municipality");
		String  gender, birthdate, municipality, phone;
		phone = scanner.nextLine();
		gender = scanner.nextLine();
		birthdate = scanner.nextLine();
		municipality = scanner.nextLine();
		Account user = new Account(name,surname, password, phone, birthdate,
				gender, municipality);
		DB data = new DB();
		try {
			data.insertAcc(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//MainMenu User = new MainMenu(user);
		//User.printMenu();
		scanner.close();
	}

}
