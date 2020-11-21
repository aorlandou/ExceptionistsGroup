
import java.util.ArrayList;
import java.util.List;
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
			String phone=friends.get(i).getPhone();
			Statement statement = con.createStatement();
			statement.executeUpdate("INSERT INTO notification" + "VALUES (phone,message");
		}
		}else {
		System.out.println("Your friends list is empty...Please add some friends first");
		}
		database.closeConnection();
	}
}

