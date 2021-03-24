package OOP_CW;
/**
* @author Sabah Ali 16058249
*/
public class Users{
	
private String UserName;
private String Password;


public Users(String UserName, String Password) 
{
	this.UserName = UserName;
	this.Password = Password;
}


/**
 * @return the Password
 */
public String getPassword() {
	return this.Password;
}


/**
 * @param Password the Password to set
 */
public void setPassword(String Password) {
	this.Password = Password;
}


/**
 * @return the UserName
 */
public String getUserName() {
	return this.UserName;
}


/**
 * @param UserName the UserName to set
 */
public void setUserName(String UserName) {
	this.UserName = UserName;
}

@Override
public String toString() {
	return "Users [UserName=" + this.UserName + ", Password=" + this.Password + "]";
}


}





