package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import model.Product;
import model.User;

/**
 * The class is a database access object (DAO) to send queries to the database
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
public class UserDao {
	/**
	 * To get all user information from database
	 * 
	 * @param connection
	 * @return
	 * @throws Exception
	 */
	Logger logger = Logger.getLogger(UserDao.class);
	public ArrayList<User> getUsers(Connection connection) throws Exception {
		logger.log(Level.INFO, "Query generated to get all user information");
		ArrayList<User> userList = new ArrayList<User>();
		try {
			Statement ps = connection.createStatement();
			ResultSet rs = ps.executeQuery("select * from users order by firstname asc");
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				userList.add(user);
			}
			return userList;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * To add new user into the database
	 * 
	 * @param user
	 * @param connection
	 */
	public void addUser(User user, Connection connection) {
		logger.log(Level.INFO, "Query generated to add new user");
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into users(firstname,lastname,role) values (?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, "user");
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Perform search operation on the database according to the search field
	 * provided by the user
	 * 
	 * @param searchString
	 * @param connection
	 * @return
	 */
	public ArrayList<Product> search(String searchString, Connection connection) {
		logger.log(Level.INFO, "Query generated for a search");
		ArrayList<Product> productList = new ArrayList<Product>();
		try {

			Statement ps = connection.createStatement();
			ResultSet rs = ps.executeQuery("select productname, description, price from products order by productname");
			while (rs.next()) {
				Product product = new Product();
				product.setProductName(rs.getString("productname"));
				product.setPrice(rs.getInt("price"));
				product.setDescription("description");
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	/**
	 * To check login credentials of a user with the database
	 * 
	 * @param userName
	 * @param password
	 * @param connection
	 * @return true if user exists in database
	 */
	public boolean login(String userName, String password, Connection connection) {
		logger.log(Level.INFO, "Query generated for login");
		Statement ps;
		try {
			ps = connection.createStatement();
			ResultSet rs = ps.executeQuery("select username, password from users");
			while (rs.next()) {
				if (rs.getString("username").equals(userName) && rs.getString("password").equals(password)) {
					return true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

}