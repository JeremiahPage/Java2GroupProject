package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This sevlet handles all Registration requests
 */
@WebServlet("/Register")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public RegistrationServlet() {
        super();
    }
    /**
     * If a get request enters this servlet it sends it to the Registration page
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Registration.jsp");
	}
	/**
	 * When posted to from Resgistration.jsp, validates input and creates a new user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Perform input checks here
		//connect to database
		//verify that email address isn't already used
		//insert new user
		//load new user into session
		
		/*
		 * Note:
		 * Might be possible to create a static class to retrieve a user and add it to the session.
		 * If not create an instance class with available methods to simplify process
		 */
	}

}
