import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/*this class is used only for testing
 * 
 */

/*Aliki an borei trekse auton ton kwdika tis erikas.*/
/*Exw kanei kapoies allages gia na borei na trexei*/
/* An thes dokimase kai tin teleutaia epilogi poy einai i diagrafi an kai*/
/* pio poly thelw na dw an leitourgei swsta to menu giati tin diagrafi tin exeis dokimasei kai esy*/
public class TestMain {

	public static void main(String[] args) {
		
	    String phone="phone";
	    String password="password";
		System.out.println("****** PROFILE EDIT ******");
		System.out.println(" [1] Change name.");
		System.out.println(" [2] Change surname.");
		System.out.println(" [3] Change password.");
		System.out.println(" [4] Change municipality.");
		System.out.println(" [5] Delete your profile.");
		System.out.println(" [0] Finish profile editing.");
		
		Scanner scanner1= new Scanner(System.in);
		int choice=scanner1.nextInt();
		DB data=new DB();
		while(choice!=0) {
			switch (choice) {
				case 1: 
					System.out.println("Please enter the name. ");
					Scanner scanner2= new Scanner(System.in);
				    String name=scanner2.nextLine();
				    data.updateName(phone,name);
				    System.out.println("Name has been changed successfully.");
				break;
				case 2:
					System.out.println("Please enter the surname. ");
					Scanner scanner3= new Scanner(System.in);
					String surname=scanner3.nextLine();
					data.updateSurname(phone, surname);
					System.out.println("Surname has been changed successfully.");
				break;
				case 3: 
					System.out.println("Please enter the new password. ");
					Scanner scanner4= new Scanner(System.in);
					String password1=scanner4.nextLine(); 
					System.out.println("Please enter again the new password. ");
					Scanner scanner5= new Scanner(System.in);
					String password2=scanner5.nextLine();
					if(password1.equals(password2)) {
						password=password1;
						System.out.println("Password has been changed successfully.");
						data.updatePassword(phone, password);}
				break;
				case 4:
					System.out.println("Please enter the new municipality. ");
					Scanner scanner6= new Scanner(System.in);
					String municipality=scanner6.nextLine();
					data.updateMunicipality(phone, municipality);
					System.out.println("Municipality has been changed successfully.");
				case 5: 
					 System.out.println("Do you want to delete your profile? If so, enter your password.");
					 Scanner scanner7= new Scanner(System.in);
					 String pass=scanner7.nextLine();
					 if(pass.equals(password)){
						 try {
							data.deleteAcc(phone);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						 System.out.println("Account has been deleted successfully.");
						 System.exit(0);
						  } 
				break;
			}
		
			System.out.println("****** PROFILE EDIT ******");
			System.out.println(" [1] Change name.");
			System.out.println(" [2] Change surname.");
			System.out.println(" [3] Change password.");
			System.out.println(" [4] Change municipality.");
			System.out.println(" [5] Delete your profile.");
			System.out.println(" [0] Finish profile editing.");
			
			Scanner scanner8= new Scanner(System.in);
			choice =scanner8.nextInt();
			}
}
}
 