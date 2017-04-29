package businessClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Hashtable;

import interfaces.Userbase;

public class HashTableAccess implements Userbase {
	File userFile = new File("C:/Windows/Temp/Users.ser");
	@Override
	public User FindUser(String username, String password) {
		Hashtable<String,HTUser> Userlist = Deserialize();
		try{
			HTUser tempUser = Userlist.get(username);
			if(tempUser.getPassword().equals(password)){
				User returnUser = new User(tempUser.getUsername(),tempUser.getFirstname());
				return returnUser;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public User AddUser(String fname, String lname, String uname, String pwd, String email) {
		Hashtable<String,HTUser> Userlist = Deserialize();
		
		HTUser tempUser = new HTUser(fname,lname,uname,pwd,email);
		Userlist.put(uname, tempUser);
		
		Serialize(Userlist);
		
		return FindUser(uname,pwd);	
	}
	
	
	private void Serialize(Hashtable<String,HTUser> ulist){
		try {
			FileOutputStream fout = new FileOutputStream(userFile);
			ObjectOutputStream objout = new ObjectOutputStream(fout);
			objout.writeObject(ulist);
			objout.close();
			fout.close();
			
		} catch (Exception e) {
			
		}
	}
	
	
	@SuppressWarnings({ "unchecked" })
	private Hashtable<String,HTUser> Deserialize (){
		try {
			FileInputStream fIn = new FileInputStream(userFile);
			ObjectInputStream ObjIn = new ObjectInputStream(fIn);
			Hashtable<String,HTUser> Userlist = (Hashtable<String, HTUser>) ObjIn.readObject();
			ObjIn.close();
			fIn.close();
			return Userlist;
			
		} catch (Exception e) {
			Hashtable<String,HTUser> Userlist = new Hashtable<String,HTUser>();
			return Userlist;
		}
		
	}

}
