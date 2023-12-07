package in.ezeon.capp.service;

import java.util.List;

import in.ezeon.capp.Exception.UserBlockedException;
import in.ezeon.capp.domain.Users;

public interface UsersService {
	//constants 
	public final static Integer Login_status_Active=1;
	public final static Integer Login_Status_Blocked=2;
	
	
	public final static Integer Role_ADMIN=1;
	public final static Integer Role_USER=2;
	
	/*The method handle the user registration task.
	 * @param u  the new user detail as Users Object. 
	 * */
	public void register(Users u);

	/*
	 * The method handles the login operation(Authentication) using the given
	 * credentials.it returns the Users obj when success and null when failed. 
	 * when user account is blocked an exception(UserBlockedException) will be thrown by these method.
	 */
	public Users login(String loginName, String password) throws UserBlockedException;
	//call this method to get the list of registered users
	public List<Users> getUsersList();
	//these method change the user login status based for details passed as argument.
	public void changeLoginStatus(Integer userId,Integer loginStatus);
	//check the userName(loginName) availability using the below method
	public boolean isUserNameExist(String userName);
}
