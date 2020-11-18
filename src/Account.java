import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.util.Date;  
public class Account {
	private  String name,surname, password, phone, birthdate, gender, municipality;
	private boolean covid;
	private String message;
	List<String> notifications= new ArrayList<String>();
	List<Account> friends= new ArrayList<Account>();
	
	public void sendNotification() {
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
			Statement statement = connection.createStatement();
			statement.executeUpdate("INSERT INTO notification" + "VALUES (phone,message");
		}
	}else {
		System.out.println("Your friends list is empty...Please add some friends first");
	}
	
}
}
