package businessClasses;

import java.io.Serializable;
import java.time.LocalDateTime;

public class HTUser implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = (long) 1.0;
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private LocalDateTime created;
	
	public HTUser(){
		
	}
	public HTUser(String firstname,String lastname, String username, String password, String email){
		this.firstname=firstname;
		this.lastname=lastname;
		this.username=username;
		this.password=password;
		this.email=email;
		this.created = LocalDateTime.now();
	}
	
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	
	

}
