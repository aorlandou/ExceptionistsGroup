
import javax.swing.JOptionPane;

public class SignUp {
	public static void creatAccount() {
			// TODO Auto-generated method stub
			String name = JOptionPane.showInputDialog("Please enter your name");
			String surname = JOptionPane.showInputDialog("Please enter your surname");
			String password = JOptionPane.showInputDialog("Please enter your password");
			String password2;
			do {
			    password2 = JOptionPane.showInputDialog("Please enter your password again to confirm");
			
				}
				while (!password2.equals(password)); 
			String phone = JOptionPane.showInputDialog("Please enter your phone number");
			String gender = JOptionPane.showInputDialog("Please enter your gender");
			String birthdate = JOptionPane.showInputDialog("Please enter your birthdate");
			String municipality = JOptionPane.showInputDialog("Please enter your municipality");
			
		Account user = new Account(name,surname, password, phone, birthdate,
				gender, municipality);
		DB data = new DB();
		try {
			data.insertAcc(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		MainMenu User = new MainMenu(user);
		User.printMenu();

		
	}

}
