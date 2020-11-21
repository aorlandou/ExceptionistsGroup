

/*this class is used only for testing
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		Account user = new Account("Aliki","Orlandou", "1234", "6940047470", "14/12/2001",
				"female" , "Marousi" );
		DB database= new DB();
		try {
			database.insertAcc(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
