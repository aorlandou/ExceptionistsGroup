
public class Account {
	private  String name, surname, password, phone, birthdate, gender, municipality;
	private boolean covid;

	void userState (boolean x){
	  covid=x ;
	  sendNotification(covid) ;
	}

	public Account(String name, String surname, String password, String phone, String birthdate, String gender, String municipality,
			boolean covid) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.birthdate = birthdate;
		this.gender = gender;
		this.municipality = municipality;
		this.covid = covid;
	}
	

}