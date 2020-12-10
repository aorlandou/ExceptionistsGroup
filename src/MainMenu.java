import java.util.Scanner;

public class MainMenu {

	private Account accountnow; // current Account

	public MainMenu(Account accountnow) {
		this.accountnow = accountnow;
	}

	public void printMenu() {
		int num;

		do {
			do {
				System.out.println("1. Friends");
				System.out.println("2. Change user state");
				System.out.println("3. Show my notifications");
				System.out.println("4. Edit profile");
				System.out.println("5. Log out");
				Scanner scan = new Scanner(System.in);
				System.out.print("Enter your choice: ");
				// This method reads the number provided using keyboard
				num = scan.nextInt();
			} while ((num < 1) || (num > 5));

			if (num == 1)
				try {
					accountnow.addFriends();
				} catch (Exception e) {
					e.printStackTrace();
				}
			else if (num == 2) {
				accountnow.userState();
			} else if (num == 3)
				accountnow.showNotifications();
			else if (num == 4)
				accountnow.editProfile();
			else if (num == 5)
				System.exit(0);
		} while (num != 5);
	}

}
