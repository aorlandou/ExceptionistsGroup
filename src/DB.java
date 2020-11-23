import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;
import java.sql.*;


	public class DB {

		private final String dbServer = "127.0.0.1";
		private final String dbServerPort = "3306";
		private final String dbName = "account";
		private final String dbusername = "root";
		private final String dbpassword = "aliki2345";

		private Connection con = null;

		/**
		 * Establishes a connection with the database, initializes and returns
		 * the Connection object.
		 *
		 * @return Connection, the Connection object
		 * @throws Exception
		 */
		public  Connection getConnection() throws Exception {

			/* Step 1 -> Dynamically load the driver's class file into memory */

			try {

				// Dynamically load the driver's class file into memory
				Class.forName("com.mysql.jdbc.Driver").newInstance();

			} catch (Exception e) {

				throw new Exception("MySQL Driver error: " + e.getMessage());
			}

			/*
			 * Step 2 -> Establish a connection with the database and initializes
			 * the Connection object (con)
			 */

			try {

				con = DriverManager.getConnection("jdbc:mysql://"
					+ dbServer + ":" + dbServerPort + "/" + dbName, dbusername, dbpassword);
				System.out.print("connected \n");
				// Step 3 -> returns the connection object
				return con;

			} catch (Exception e) {

				// throw Exception if any error occurs
				throw new Exception("Could not establish connection with the Database Server: "
					+ e.getMessage());
			}
		} // End of getConnection
		
		/*this method closes the connection with the database
		 * 
		 */
		public void closeConnection() throws SQLException {

			try {

				// if connection is (still) open
				if (con != null)
					con.close(); // close the connection to the database to end database session

			} catch (SQLException e) {

				throw new SQLException("Could not close connection with the Database Server: "
					+ e.getMessage());
			}

		}//end of closeConnection
		
		/*this method will insert an account to our database
		 * 
		 */
		public void insertAcc(Account ac) throws Exception {
			try {
				DB database = new DB();
				Connection con = database.getConnection();
				String SQL = "INSERT INTO account(phone, name, surname, password, "
						+ "municipality, gender, birthdate) "
		                + "VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(SQL);
				
				pstmt.setString(1, ac.getPhone());
				pstmt.setString(2, ac.getName());
				pstmt.setString(3, ac.getSurname());
				pstmt.setString(4, ac.getPassword());
				pstmt.setString(5, ac.getMunicipality());
				pstmt.setString(6, ac.getGender());
				pstmt.setString(7, ac.getBirthdate());
				
				int row = pstmt.executeUpdate();
				
				System.out.println("Number of rows inserted:" + row);
				
				database.closeConnection();
			} catch (Exception e) {
				throw new Exception("Could not insert account to the database: "
						+ e.getMessage());
			}
			
		}//end of incertAcc
		
	}
