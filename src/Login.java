import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Login {
	
	public static void loginMethod() throws InputMismatchException {
		 
		int answer; //user's phonenumber is expected
		int pass; //user's password is expected
		
		Scanner sc = new Scanner(System.in);
	
		DB dbConnection = new DB(); //connect with DataBase

		dbConnection.getConnection();

		boolean continueLoop = true;
		do {
			try { //read the phonenumber and the password from user
				System.out.println("Please enter your phonenumber");
				answer = sc.nextInt(); // user enters a number
				
					try {
						//research on database	
						Statement st = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE); 
						ResultSet frs = st.executeQuery("select answer from accounts");
						int x = frs.getInt(1);
								
						if (x == answer) {
						//the phonenumber exists
									
							String ans;
							int y;
							int i;
							do {
								System.out.println("Please enter your password to continue");
								pass = sc.nextInt();
								i++;
								ResultSet srs = st.executeQuery("select pass from accounts");
								y = srs.getInt(4);
								if (y == pass) {
											
									//CONTINUE PROCESS OF LOGIN
											
								} else {
									System.out.println("Invalid password\n Do you want to try again?");
										ans = sc.nextLine();
								}
						
							} while((ans.equals("no") || y == pass) && i > 5);
								
						} else { //phonenumber does not exist on database
							System.out.println("We are sorry this phonenumber does not exist");
							System.out.println("If you want to register please select the option Signin");
						}
										
						} catch(ClassNotFoundException cnfe){
								cnfe.printStackTrace();
						}catch (SQLException se){
								se.printStackTrace();
						}

				continueLoop = false; //no exceptions where found
			} //end try
			catch (InputMismatchException e1){ //In case of invalid data
				System.err.printf("\n exception: %s \n", e1);
				sc.nextLine(); //discard input so that user can try again
				System.out.println("Please enter valid characters (integers");
			}

		} while (continueLoop);

	}
}
