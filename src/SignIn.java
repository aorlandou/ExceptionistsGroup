import java.util.Scanner;

public class SignIn {
	public static void creatAccount() {
		System.out.println("Please enter your name and your password");
		Scanner scanner = new Scanner(System.in);
		String name, password; 
		name = scanner.nextLine();
		password = scanner.nextLine();
		System.out.println("Please enter your password again to confirm");
		String password2;
		password2 = scanner.nextLine();
		while (password2 != password);{
			System.out.println("Please enter your password again correctly");
			password2 = scanner.nextLine();
		}
		System.out.println("Please enter your phone number, your gender, your birthdate and your municipality");
		String phone, gender, birthdate, municipality;
		phone = scanner.nextLine();
		gender = scanner.nextLine();
		birthdate = scanner.nextLine();
		municipality = scanner.nextLine();
		Account user = new Account(name, password, phone, gender, birthdate, municipality );
		MainMenu User = new MainMenu(user);
		User.printMenu();
	}

}
