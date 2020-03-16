package DataAccessObject;

import java.sql.Connection;

import Modle.User;
import Util.DataGetUtil;

public class UserDAO {
	DataGetUtil dgu = new DataGetUtil();
	
	// This method is for user to login
	public User login(User user) throws Exception{
			
		// The username and passwd have not been check yet, the user need to be initialized as null.
		User result = null;
		dgu.dbProductGet();
		for(User u : dgu.dbUserGet()) {
			
			if (user.getUserName().equals(u.getUserName()) && user.getPasswd().equals(u.getPasswd()) ) {
				System.out.println("Login Successful!");
				result = user;
			}
		}

		return result;
		
	}
	
	
}
