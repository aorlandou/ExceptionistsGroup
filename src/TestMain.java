import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/*this class is used only for testing
 * 
 */
public class TestMain {

	public static void main(String[] args) {
		/*search for password that connects to the phone given by the user
		 * 
		 */
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
		
 
	/*update account fields
	 * 
	 */
	String newpassword="100";
	String phone="6955300531";
	String SQL = "UPDATE account SET password = ? WHERE phone = ?";
	PreparedStatement pstmt = null;
	try {
		connection = database.getConnection();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt = connection.prepareStatement(SQL);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(1,newpassword);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.setString(2,phone);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		pstmt.executeUpdate();
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
		

	 /*Test getVariable DB class*/
	DB data=new DB();
	String variable=data.getPassword("6955300531");
	System.out.println(variable);
	
	}	
}
 