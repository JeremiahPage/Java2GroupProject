package businessClasses;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * This class is used to hold and control all access to the database
 *
 */
public class DatabaseAccess {
	private String cString = "";
	private String dUserName = "";
	private String dPassword = "";
	/**
	 * This will be used to verify if a user exists and if their password is correct
	 */
	public User FindUser(String username, String password){
		//Select Statement
		try {
			//creates a dynamic query based on user input
			String query="Select firstname, username from Users where username = " + username + "and password = " + password + ";";
			
			Connection conn = (Connection) DriverManager.getConnection(cString,dUserName,dPassword);
			Statement stmt = (Statement) conn.createStatement();
			ResultSet results = stmt.executeQuery(query);
			
			//returns null if no result sets are returned.
			if (!results.isBeforeFirst() ) {    
			   return null;
			}else{
				while(results.next()){ 
					return new User(results.getString("firstname"),results.getString("username"));
				}
			}
		} catch (SQLException e) {
				return null;
		}
		//Shouldn't be able to get to this code, but eclipse seems to think otherwise. I believe its because of the while loop, where I know it must exist eclipse does not.
		return null;
	}
	
	
	/**
	 * This adds a new user to the database
	 */
	public User AddUser(String fname, String lname, String uname, String pwd, String email){
		
		String query = "Insert into Users (firstname, lastname, username, password, email) values (" + fname +", " + lname + ", " + uname + ", " + pwd + ", " + email + ");";
		
		try {
			Connection conn = (Connection) DriverManager.getConnection(cString,dUserName,dPassword);
			Statement stmt = (Statement) conn.createStatement();
			//run the insert
			stmt.executeUpdate(query);
			/*
			 * This is a bit convoluted. It runs the find user query which will then check to make sure that this successfully updated the database.
			 * It also gets and returns a user if successful which is created by the FindUser method
			 * I'm not sure if this returns an error if it tries to duplicate keys, but if it doesn't this is to check to make sure that didn't happen.
			 */
			return FindUser(uname,pwd);
			
		} catch (SQLException e) {
			return null;
		}
	}
	
	
}
