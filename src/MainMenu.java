import java.util.Scanner;


public class MainMenu {

	
	private Account accountnow; 
	 MainMenu(Account currentaccount){
		accountnow= currentaccount;
	}
	MainMenu(){
		 System.out.println("Account has been created");
	 }
	public void printMenu(){
		int num;
        do {
		   do{	
	         	 System.out.println("1. add new friends");
	         	 System.out.println("2. change user state");
	         	 System.out.println("3. show my notifications");
	         	 System.out.println("4. edit profile");
	         	 System.out.println ("5. log out");
	         	 Scanner scan= new Scanner(System.in);
	         	 System.out.print("Enter your choice: ");
	         	 // This method reads the number provided using keyboard
	         	 num= scan.nextInt();
		   }while ((num<1) || (num>5)); 
		   
	          if (num==1)
	        	  accountnow.setFriends();
	          else if (num==2) { 
	        	   
	        	  String key; 
	        	  System.out.println("Have you been tested positive (yes) or negative (no) for COVID-19? ");
	        	  Scanner scanner= new Scanner(System.in);
	        	  this.key=scanner.nextLine();
	     		    
	     		  Account.userState(key);
	          }
	          else if (num==3) 
	        	  Account.showNotification();
	          else if (num==4)
	        	  Account.editProfile();
	          else if (num==5)
	        	  Account.logOut();
        		
        } while (num!=5);
		
}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
                 //private Account accountnow; 
		MainMenu x = new MainMenu(); 
		x.printMenu();
		}
	}

