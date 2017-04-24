package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessClasses.DatabaseAccess;
import businessClasses.User;

/**
 * This Servlet handles all login requests 
 *
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public LoginServlet() {
        super();
    }
    /**
     * If a get request enters this servlet it sends it to the Login page
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("views/Logon.jsp");
	}

	/**
	 * When posted from the Login page, this authorizes the user and adds the user to the session state
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Session
		HttpSession session = request.getSession();
		//Gets the submitted name and pwd
		String tempUsername = request.getParameter("username");
		String tempPassword = request.getParameter("pwd");
		//Holding variables
		String fwdLoc,errorMessage;
		
		/*
		 * Perform check on input before sending them to the databse
		 */
		
		
		
		//Create an access class
		DatabaseAccess access = new DatabaseAccess();
		//This method gets a user object if one exists
		User tempUser = access.FindUser(tempUsername, tempPassword);
		
		
		if(tempUser == null){
			//This happens when the username and password are not verified
			errorMessage = "Username or Password incorrect";
			session.setAttribute("Error", errorMessage);
			fwdLoc="views/Logon.jsp";
		}
		else{
			session.setAttribute("User", tempUser);
			fwdLoc="views/Index.jsp";
		}
		
		response.sendRedirect(fwdLoc);
	}

}
