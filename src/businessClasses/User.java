package businessClasses;

/**
 * This Class is used to build and maintain a user during a session.
 * 
 */
public class User {

	/**
	 * The fname is so the users name is displayed on the website
	 * the username is so that it is easier to access the database if needed
	 */
	private String fname;
	private String username;
	
	/**
	 * Default Constructor for the user Object
	 * 
	 */
	public User(){
		
	}
	
	/**
	 * 
	 * @param fname first name of the user
	 * @param username username of the user
	 */
	public User(String fname, String username){
		this.fname=fname;
		this.username=username;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
