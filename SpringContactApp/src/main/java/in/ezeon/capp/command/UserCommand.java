package in.ezeon.capp.command;

import in.ezeon.capp.domain.Users;

public class UserCommand {
	// i am reusing my doamin class(Users.java) in a command. 
	Users user;
	//TODO:if you required add more fields 

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
