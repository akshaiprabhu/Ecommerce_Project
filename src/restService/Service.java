package restService;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import controller.UserController;
import model.User;

/**
 * The class has method to provide get all user service.
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
@Path("/Service")
public class Service {
	Logger logger = Logger.getLogger(Service.class);
	@GET
	@Path("/getUsers")
	public String feed() {
		String result = new String();
		logger.log(Level.INFO, "Servicing admin for get all user information");
		try {
			ArrayList<User> data = null;
			UserController cntrl = new UserController();
			data = cntrl.getUsers();
			Gson gson = new Gson();
			System.out.println(gson.toJson(data));
			result = gson.toJson(data);
		}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return result;
	}

	/**
	 * Take user input for registration and a new user
	 * 
	 * @param firstName
	 * @param lastName
	 * 
	 * @param servletResponse
	 * @throws Exception
	 */
	@POST
	public void userFeed(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@Context HttpServletResponse servletResponse) throws Exception {
		
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		UserController cntrl = new UserController();
		logger.log(Level.INFO, "New user information received");
		cntrl.addUser(user);
		servletResponse.sendRedirect("../rest/Service/getUsers");
	}

}