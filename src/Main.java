import java.util.Scanner;
public class Main {
	System.out.println("If you want to sign in press 1,if you want to log in press 2");
	Scanner sc = new Scanner(System.in);
	int choice;
	choice = sc.nextInt();
	while(choice != 1 && choice != 2){
			System.out.println("Please enter a valid answer"); 
		    choice = sc.nextInt();
	}
	if (choice == 1) {
		public static SignIn account1 = new SignIn();
		account1.creatAccount();
	}
	if (choice == 2) {
		public static LogIn account2 = new LogIn();
		account2.enterAccount();
	}
}
