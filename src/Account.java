import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Collections;
import java.util.InputMismatchException;


public class Account {
	private  String name, surname, password, birthdate, gender, municipality;
	private String phone;
	private String covidState; //returns "yes" if user has covid or "no" if he doesn't have
	private String message;
	List<String> notifications= new ArrayList<String>();
	List<String> friends= new ArrayList<String>();
	
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

	public String getCovidState() {
		return covidState;
	}

	public void setCovidState(String covidState) {
		this.covidState = covidState;
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

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}


	

	void userState (String key){
	  boolean x=Boolean.parseBoolean(key);
	  covid=x ;
	  try {
		sendNotification() ;
	} catch (Exception e) {
		e.printStackTrace();
	}
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

	/*
	 * This method adds a new notification in every friend's notification list when
	 * the user is tested positive or negative for the virus
	 */
	public void sendNotification() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		if (covidState == true) {
			message = "Your friend " + surname + " " + name + " has been tested possitive for coronavirus "
					+ formatter.format(date);
		} else {
			message = "Your friend " + surname + " " + name + " has recovered from coronavirus "
					+ formatter.format(date);
		}
		if (friends.size() != 0) {
			for (int i = 0; i < friends.size(); i++) {
				DB data = new DB();
				data.addNotification(friends.get(i), message);

			}

		} else {
			System.out.println("Your friends list is empty...Please add some friends first");
		}

	}
	
	
	public void editProfile() {
		
		System.out.println("****** PROFILE EDIT ******");
		System.out.println(" [1] Change name.");
		System.out.println(" [2] Change surname.");
		System.out.println(" [3] Change password.");
		System.out.println(" [4] Change municipality.");
		System.out.println(" [5] Delete your profile.");
		System.out.println(" [0] Finish profile editing.");
		
		Scanner scanner1= new Scanner(System.in);
		int choice=scanner1.nextInt();
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
					if(password1.equals(password2)) {
						this.password=password1;
						System.out.println("Password has been changed successfully.");	}
				break;
				case 4:
					System.out.println("Please enter the new municipality. ");
					Scanner scanner6= new Scanner(System.in);
					this.municipality=scanner6.nextLine();
				case 5: 
					 System.out.println("Do you want to delete your profile? If so, enter your password.");
					 Scanner scanner7= new Scanner(System.in);
					 String pass=scanner7.nextLine();
					 /*if(pass.equals(this.password)){
						  user=null; 
						 System.gc();
						 boolean flag=true;
						  } */
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
		
	
		public void showNotifications() {
			  Collections.sort(notifications);
			  for (int i = 0; i <notifications.size(); i++) {
			      System.out.println(notifications.get(i));
		  }
	}
		
		public void addFriends () throws Exception {

			Scanner scanner8 = new Scanner(System.in);
			int selection = 1;
			boolean check = true; 
			while (check) {
				try {
					System.out.println("Enter 1 to show friends or enter 2 to add a new friend.\n");
					selection = scanner8.nextInt();
					if (selection == 1 || selection == 2)
						check = false;
					else
						check = true;
				} catch (InputMismatchException e) {
					System.out.println("An error has occured, please try again.\n");
					scanner8.nextLine();
				}
			}
			if (selection == 1) {
				if (friends.size() != 0) {
					try {
						System.out.println("Your current friends are:\n");
						DB d = new DB();
						Connection con = d.getConnection();
						for (int i=0; i<friends.size(); i++) {
							System.out.println(d.getName(friends.get(i)) + " " 
							+ d.getSurname(friends.get(i)) + " " + friends.get(i) + "\n");
						}
						d.closeConnection();
					} catch (Exception e) {
						throw new Exception("Could not show friends: "
								+ e.getMessage());
					}
				} else {
					System.out.println("Your friend list is empty...Please add some friends first. \n");
				}
			} else {
				String process = "continue";
				while (process.contentEquals("continue")) {
					DB dd = new DB(); 
					try {
						System.out.println("Please enter your friend's phone number.");
						String friendphone = scanner8.next();
						String answer = dd.getName(friendphone);
						if (answer.equals("nothing returned")) {
							System.out.println("Sorry but this phonenumber does not exist. \n Back in menu");
							return;
						} else {
							friends.add(friendphone);
						}
						System.out.println("If you would like to add more friends enter continue, "
								+ "otherwise enter stop.");
						process = scanner8.next();
					} catch(InputMismatchException e) {
						System.err.printf("\n Exception: %s \n", e);
						System.out.println("Invalid data \n Try again");
						scanner8.nextLine();
					}
				}
			}
	}
}
