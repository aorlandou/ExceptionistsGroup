
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;

public class Account {
	private  String name, surname, password, birthdate, gender, municipality;
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
}

