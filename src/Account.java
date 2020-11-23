
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Account {
	private  String name, surname, password, birthdate, gender, municipality;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}


	private int phone;
	private boolean covid;
	private String message;
	List<String> notifications= new ArrayList<String>();
	List<Account> friends= new ArrayList<Account>();

	void userState (boolean x){
	  covid=x ;
	  sendNotification() ;
	}

	public Account(String name, String surname, String password, int phone, String birthdate,
			String gender, String municipality) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.phone = phone;
		this.birthdate = birthdate;
		this.gender = gender;
		this.municipality = municipality;
	}
	
	
	public void sendNotification() {
		DB database= new DB();
		Connection con=database.getConnection();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		if(covid==true) {
			message="Your friend "+surname+" "+name+" has been tested possitive for coronavirus "+formatter.format(date);
		}else {
			message="Your friend "+surname+" "+name+" has recovered from coronavirus "+formatter.format(date);
		}
		if(friends.size()!=0) {
		for(int i=0;i<friends.size();i++) {
			int phone=friends.get(i).getPhone;
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO notification" + "VALUES (phone,message");
		}
		}else {
		System.out.println("Your friends list is empty...Please add some friends first");
		}
		database.closeConnection();
	}
<<<<<<< HEAD
	database.close();
}
	
>>>>>>> master
	public void editProfile() {
		System.out.println("****** PROFILE EDIT ******");
		System.out.println(" [1] Change name.");
		System.out.println(" [2] Change surname.");
		System.out.println(" [3] Change password.");
		System.out.println(" [4] Cchange municipality.");
		System.out.println(" [0] Finish profile editing.");

		Scanner scanner= new Scanner(System.in);
		int choice =scanner.nextInt();
		while(choice!=0) {
			switch (choice) {
				case 1: 
					System.out.println("Please enter the name. ");
					name=scanner.nextLine();
				break;
				case 2:
					System.out.println("Please enter the surname. ");
					surname=scanner.nextLine();
				break;
				case 3: 
					System.out.println("Please enter the new password. ");
					String password1=scanner.nextLine();
					System.out.println("Please enter again the new password. ");
					String password2=scanner.nextLine();
					if(password1==password2) {
						password=scanner.nextLine(); }
				break;
				case 4:
					System.out.println("Please enter the new municipality. ");
					municipality=scanner.nextLine();
				break;
			}
			choice =scanner.nextInt();
			}
		  System.out.println("Do you want to delete your profile? If so, enter your password.");
		  Scanner scanner1= new Scanner(System.in);
		  String pass=scanner1.nextLine();
}
		  public void showNotifications() {
			  Collections.sort(notifications);
			  for (int i = 0; i <notifications.size(); i++) {
			      System.out.println(notifications.get(i));
		  }
		
}
		  }
