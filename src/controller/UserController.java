package controller;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import connect.ConnectToDB;
import dao.UserDao;
import model.User;

/**
 * The class is the controller class, a middle layer between the view and model.
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
public class UserController {
	Logger logger = Logger.getLogger(UserController.class);
	Connection connection = null;

	/**
	 * Controls database connection
	 * @throws Exception
	 */
	public UserController() throws Exception {
		logger.log(Level.INFO, "Database connection requested");
		ConnectToDB connect = new ConnectToDB();
		connection = connect.connect();
	}

	/**
	 * Controller to get all user information
	 * @return
	 * @throws Exception
	 */
	public ArrayList<User> getUsers() throws Exception {
		ArrayList<User> users = null;
		logger.log(Level.INFO, "Request to get all user information by admin");
		UserDao userdao = new UserDao();
		users = userdao.getUsers(connection);
		return users;
	}

	/**
	 * Controller to add new user
	 * @param user
	 * @throws Exception
	 */
	public void addUser(User user) throws Exception {
		logger.log(Level.INFO, "New user registration requested");
		try {
			UserDao userdao = new UserDao();
			userdao.addUser(user, connection);
		} catch (Exception e) {
			// System.out.println(connection);
			throw e;
		}
	}

	/**
	 * Controller for login requests
	 * @param userName
	 * @param password
	 * @return
	 */
	public boolean login(String userName, String password) {
		logger.log(Level.INFO, "User login requested");
		UserDao userdao = new UserDao();
		if (userdao.login(userName, password, connection)) {
			return true;
		}
		return false;
	}
}