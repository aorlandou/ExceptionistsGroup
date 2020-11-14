
public class Account {
	private  String name, password, phone, birthdate, gender, municipality;
	private boolean covid;
	
	void userState (boolean x){
	covid=x ;
	sendNotification(covid) ;
	}
}
