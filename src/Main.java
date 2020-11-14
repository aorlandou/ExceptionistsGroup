import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {
	public static void main(String[] args){
		int choice;
		Scanner sc = new Scanner(System.in);
		do{
			try
			{
			    System.out.println("If you want to sign in press 1,if you want to log in press 2");
				choice = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please enter a valid answer"); 
		    	choice = sc.nextInt();
			}
		}while(choice != 1 && choice != 2);
		if (choice == 1) {
			SignIn.creatAccount();
		}
		if (choice == 2) {
			LogIn.enterAccount();
		}
	}
}
