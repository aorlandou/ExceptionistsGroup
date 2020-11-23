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

	
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query="SELECT password FROM account WHERE phone = 6940047470 ";
		 
		
		
		try {
			results = statement.executeQuery(query);
			while(results.next()) {
				 try {
					String pass =results.getString("password");
					System.out.println("user password:" + pass);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 try {
			database.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
}