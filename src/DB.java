import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;


	public class DB {

		/* Database connection settings, change dbName, dbusername, dbpassword */
		private final String dbServer = "127.0.0.1";
		private final String dbServerPort = "3306";
		private final String dbName = "MySQL";
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
		public Connection getConnection() throws Exception {

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
				System.out.print("connected");
				// Step 3 -> returns the connection object
				return con;

			} catch (Exception e) {

				// throw Exception if any error occurs
				throw new Exception("Could not establish connection with the Database Server: "
					+ e.getMessage());
			}
		} // End of getConnection
	}
