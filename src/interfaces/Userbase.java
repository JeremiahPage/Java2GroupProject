package interfaces;

import businessClasses.User;

public interface Userbase {
	public User FindUser(String username, String password);
	public User AddUser(String fname, String lname, String uname, String pwd, String email);
}
