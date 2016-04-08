package restService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import controller.UserController;

/**
 * The class has method to provide with login service.
 * 
 * @author Akshai Prabhu
 * @author Ketki Trimukhe
 * @author Vishal Dsouza
 */
@Path("/loginService")
public class loginService {
	Logger logger = Logger.getLogger(loginService.class);

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void login(@FormParam("form-username") String username, @FormParam("form-password") String password,
			@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception {
		UserController cntrl = new UserController();

		System.out.println(username + "---" + password);
		if (username.trim().equals("")) {

		} else if (password.trim().equals("")) {

		} else if (cntrl.login(username, password)) {
			response.sendRedirect("../index.jsp");
			logger.log(Level.INFO, "User login: " + username + "," + password);
		} else {
			request.setAttribute("errorMessage", "Please enter proper credentials");
			request.getRequestDispatcher("../register.jsp").forward(request, response);
			logger.log(Level.ERROR, "User login failed: " + username + "," + password);
		}
	}
}
