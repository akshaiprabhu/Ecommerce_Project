package connect;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * The class has method to connect to database.
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
public class ConnectToDB {

	Logger logger = Logger.getLogger(ConnectToDB.class);

	/**
	 * The method is used to connect to the database
	 * 
	 * @return connection variable
	 */
	public Connection connect() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();

			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:", "system", "system");
			logger.log(Level.INFO, "Connected to DB");
			System.out.println(connection);
		} catch (Exception e) {
			logger.log(Level.ERROR, "DB connection failed");
		}
		return connection;
	}

}
