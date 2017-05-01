package businessClasses;

public class PasswordValidation {
private String Password = "";
private String Error = "";
private Boolean a = null;
private int numcounter=0;
private int Upper = 0;
private int lower= 0;

public PasswordValidation(){
	
	 this.Password="";
	 this.Error="";
	 this.a=null;
	 this.numcounter=0;
	 this.Upper=0;
	 this.lower=0;
}
public PasswordValidation(String Password){
	
	 this.Password=Password;
	 this.Error="";
	 this.a=null;
	 this.numcounter=0;
	 this.Upper=0;
	 this.lower=0;
}
public void NewPassword(String Password){
	
	 this.Password=Password;
	 this.Error="";
	 this.a=null;
	 this.numcounter=0;
	 this.Upper=0;
	 this.lower=0;
}
public String GetErro(){
	
	return Error;
}
public int Numbercounter(){
	
	return numcounter;
}
public int NumberLower(){
	
	return lower;
}
public int NumberUpper(){
	
	return Upper;
}
public int Passwordlenght(){
	
	return  this.Password.length();
}
public Boolean restrictions(){
	
	if(Password.length()>=8){
		
	for(int i =0; i<Password.length();i++){
		String sub= Password.substring(i, i+1);
		if(sub.equals("0")|| sub.equals("1")||sub.equals("2")|| sub.equals("3")||sub.equals("4")||sub.equals("5")|| sub.equals("6")||sub.equals("7")|| sub.equals("8")||sub.equals("9")){
		numcounter ++;	
		}
		char ch = Password.charAt(i);
		if(Character.isUpperCase(ch)){
			Upper++;
		}
		if(Character.isLowerCase(ch)){
			lower++;
		}
	}
		if(numcounter > 0){
			if( Upper > 0 ){
				if(lower > 0){
					a = true;
				}else{
					a = false;
					if(Error==""){
					Error="Needs Lowercase Letter";
					}else{
						Error +=" Needs Lowercase Letter";	
					}
				}
			}else{
				a = false;
				if(Error==""){
				Error="Needs Uppercase Letter";
				}else{
					Error +=" Needs Uppercase Letter";	
				}
			}
		}else{
			a = false;
			if(Error==""){
			Error="Needs number";
			}else{
				Error +=" Needs number";	
			}
		}
		
		
		
	}else{
		a = false; 
		Error="not long enough";
	}
	if(Error==""){
		Error="NoN";
	}
	return a;
}
}
