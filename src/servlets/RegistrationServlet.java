package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import businessClasses.DatabaseAccess;
import businessClasses.HashTableAccess;
import businessClasses.User;
import businessClasses.PasswordValidation;;
/**
 * This servlet handles all Registration requests
 */
@SuppressWarnings("unused")
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
		response.sendRedirect("views/Registration.jsp");
	}
	/**
	 * When posted to from Resgistration.jsp, validates input and creates a new user.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Session
		HttpSession session = request.getSession();
		//Gets the submitted name and pwd
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String uname = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String vpwd = request.getParameter("vpwd");
		String email = request.getParameter("email");
		//Holding variables
		String fwdLoc = "",errorMessage;
		
		//perform input validation here
		
		PasswordValidation pass = new PasswordValidation();
		pass.NewPassword(pwd);
		if(pass.restrictions()){
		if(!pwd.equals(vpwd)){
			fwdLoc = "views/Registration.jsp";
			errorMessage="Passwords do not match";
			session.setAttribute("Error", errorMessage);
		}else{
			//This means that the input has passed all initial validation and is being sent to the server
			HashTableAccess access = new HashTableAccess();
			//DatabaseAccess access = new DatabaseAccess();	
			User tempUser = access.AddUser(fname, lname, uname, pwd, email);
		
			if(tempUser == null){
				fwdLoc = "views/Registration.jsp";
				errorMessage="Username already exists";
				session.setAttribute("Error", errorMessage);
			}else{
				fwdLoc = "views/Index.jsp";
				session.setAttribute("User", tempUser);
			}
		}
		}else{
			errorMessage=pass.GetErro();
			log(errorMessage);
			fwdLoc = "views/Registration.jsp";
			session.setAttribute("Error", errorMessage);
			
		}
		response.sendRedirect(fwdLoc);	
		
	}

}
