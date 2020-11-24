
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Collections;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public boolean isCovid() {
		return covid;
	}

	public void setCovid(boolean covid) {
		this.covid = covid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<String> notifications) {
		this.notifications = notifications;
	}

	public List<Account> getFriends() {
		return friends;
	}

	public void setFriends(List<Account> friends) {
		this.friends = friends;
	}


	private String phone;
	private boolean covid;
	private String message;
	List<String> notifications= new ArrayList<String>();
	List<Account> friends= new ArrayList<Account>();

	void userState (boolean x){
	  covid=x ;
	  sendNotification() ;
	}

	public Account(String name, String surname, String password, String phone, String birthdate,
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
	
	
	public void sendNotification() throws Exception {
		DB database= new DB();
		Connection con;
		
			con = database.getConnection();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();  
		if(covid==true) {
			message="Your friend "+surname+" "+name+" has been tested possitive for coronavirus "+formatter.format(date);
		}else {
			message="Your friend "+surname+" "+name+" has recovered from coronavirus "+formatter.format(date);
		}
		if(friends.size()!=0) {
		for(int i=0;i<friends.size();i++) {
			String phone=friends.get(i).getPhone();
			Statement statement;
			
				statement = con.createStatement();
			
				statement.executeUpdate("INSERT INTO notification" + "VALUES (phone,message");
			
				
			}
		
		}else {
		System.out.println("Your friends list is empty...Please add some friends first");
		}
		database.closeConnection();
	}
	public void editProfile() {
		System.out.println("****** PROFILE EDIT ******");
		System.out.println(" [1] Change name.");
		System.out.println(" [2] Change surname.");
		System.out.println(" [3] Change password.");
		System.out.println(" [4] Change municipality.");
		System.out.println(" [0] Finish profile editing.");

		Scanner scanner1= new Scanner(System.in);
		int choice =scanner1.nextInt();
		while(choice!=0) {
			switch (choice) {
				case 1: 
					System.out.println("Please enter the name. ");
					Scanner scanner2= new Scanner(System.in);
				    this.name=scanner2.nextLine();
				break;
				case 2:
					System.out.println("Please enter the surname. ");
					Scanner scanner3= new Scanner(System.in);
					this.surname=scanner3.nextLine();
				break;
				case 3: 
					System.out.println("Please enter the new password. ");
					Scanner scanner4= new Scanner(System.in);
					String password1=scanner4.nextLine(); 
					System.out.println("Please enter again the new password. ");
					Scanner scanner5= new Scanner(System.in);
					String password2=scanner5.nextLine();
					if(password1==password2) {
						this.password=password1;
						System.out.println("Password has been changed successfully.");	}
				break;
				case 4:
					System.out.println("Please enter the new municipality. ");
					Scanner scanner6= new Scanner(System.in);
					this.municipality=scanner6.nextLine();
				break;
			}
			Scanner scanner7= new Scanner(System.in);
			choice =scanner7.nextInt();
			}
		
		  System.out.println("Do you want to delete your profile? If so, enter your password.");
		  Scanner scanner7= new Scanner(System.in);
		   String pass=scanner7.nextLine();
		/* p = null;
		    System.gc();*/
	}
		public void showNotifications() {
			  Collections.sort(notifications);
			  for (int i = 0; i <notifications.size(); i++) {
			      System.out.println(notifications.get(i));
		  }
	}
	
}