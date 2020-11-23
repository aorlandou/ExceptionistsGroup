import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/*this class is used only for testing
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		Account user = new Account("Aliki","Orlandou", "1234", "6940047470", "14/12/2001",
				"female" , "Marousi" );
		DB database= new DB();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			connection = database.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String get=".";
	
	try {
		statement = connection.createStatement();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String query="SELECT password FROM account WHERE phone LIKE 6955300531";
	 
	
	try {
		results = statement.executeQuery(query);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		if(results.next()) {
			 try {
				get=results.getString("");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	 
	 System.out.print(get);
	 
	// For each row of the result set ...
	 
	
	 

}
}