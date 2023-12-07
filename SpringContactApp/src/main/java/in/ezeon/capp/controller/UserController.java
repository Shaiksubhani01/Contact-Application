package in.ezeon.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ezeon.capp.Exception.UserBlockedException;
import in.ezeon.capp.command.LoginCommand;
import in.ezeon.capp.command.UserCommand;
import in.ezeon.capp.domain.Users;
import in.ezeon.capp.service.UsersService;

@Controller
public class UserController {
	@Autowired
	private UsersService uService;

//here i am going to use these model and you need to bind your command then only it is accesable in jsp-page(view)
	@RequestMapping(value = { "/", "/index" }) // for multiple urls
	public String index(Model m) {
		// bind your command here
		m.addAttribute("command", new LoginCommand());
		return "index"; // JSP - /WEB-INF/view/index.jsp
	}

	// The details will be taken here and the complete details will be available here in the form of model attribute and the complete form data will be available here
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m,HttpSession session) {
		try {
			Users loggedInUser = uService.login(cmd.getLoginName(), cmd.getPassword());

			if (loggedInUser == null) {
				// FAILED
				// add error message and go back to login-form
				m.addAttribute("err", "Login Failed! enter the valid credentials.");

				return "index";// jsp-Login Form
			} else {
				// success
				// check the role and redirect to a appropriate dashboard
				if (loggedInUser.getRole().equals(UsersService.Role_ADMIN)) {
					// add user detail in session(assign session to loggedIn user)
                        addUserInSession(loggedInUser, session);
					// to redirect you have to use these redirect: prefix.
					return "redirect:admin/dashboard";
				} else if (loggedInUser.getRole().equals(UsersService.Role_USER)) {
					// add user detail in session(assign session to loggedIn user)
					  addUserInSession(loggedInUser, session);
					return "redirect:user/dashboard";
				} else {
					// add error message and go back to login-form
					m.addAttribute("err", "Invalid User-Role");
					return "index";// jsp-Login Form
				}
			}
		} catch (UserBlockedException e) {

			// add error message and go back to login-form
			m.addAttribute("err", e.getMessage());
			return "index";// jsp-Login Form
		}

	}

	@RequestMapping(value = "/logout")
	//for logout you need to terminate the session 
	public String logout(HttpSession session) {
		//when user is logout you have to terminate the user Session
		session.invalidate();
		//here you can add one flag here just to display the appropriate mess on the index page 
		return "redirect:index?act=lo"; // JSP - /WEB-INF/view/dashboard_user.jsp
	}
	
	
// i am catogerizing the url according to the role.so all the urls related to the user will be starting from the  /user/ 
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "dashboard_user"; // JSP - /WEB-INF/view/dashboard_user.jsp
	}

//i am catogerizing the url according to the role.so all the urls related to the admin will be starting from the  /admin/ 
	@RequestMapping(value = "/admin/dashboard")
	public String adminDashboard() {
		return "dashboard_admin"; // JSP - /WEB-INF/view/dashboard_admin.jsp
	}
	//i am catogerizing the url according to the role.so all the urls related to the admin will be starting from the  /admin/ 
		@RequestMapping(value = "/admin/users")
		public String getUserList(Model m) {
			// so all the users will be  return by the below method and it is added in the requestScope(model obj) through the userList
			m.addAttribute("userList", uService.getUsersList());//now i can access these userList form the page users.
			
			return "users"; // JSP - /WEB-INF/view/users.jsp
		}
	
	// here i am going to bind the UserCommand
	@RequestMapping(value = "/reg_form")
	public String registrationForm(Model m){
		UserCommand cmd=new UserCommand();
		m.addAttribute("command",cmd);//command bind here 
		//now these command is bind with the modal which is accessable from the jsp page.
		return"reg_form";//jsp
	}
	
	/* i can read here  form data from these  modelAttribute */
		@RequestMapping(value = "/register",method = RequestMethod.POST)
		public String registerUser(@ModelAttribute("command") UserCommand cmd,Model m ){
			//you can access the Users Object From the command 
		try {
		    Users user=cmd.getUser();// it is containg all the user registration details you have to pass these Users obj to the service Layer
			user.setLoginStatus(UsersService.Login_status_Active);
			user.setRole(UsersService.Role_USER);
			uService.register(user);
		// if  everything is correct we will go to the index page where u will see the login form
		 return"redirect:index?act=reg";//login-page 
		}catch(DuplicateKeyException e) {
			//bind here error message 
		m.addAttribute("err","UserName is already registered! Please select another UserName.");
			return "reg_form";//jsp      //here when something went wrong we will forward to the form again
			
		}
		 
			
		}
		@RequestMapping(value = "/admin/change_status")
		/*This will recieve the call and i am going to use  ajax the response will be automatically send through the output-stream 
		 * instead of finding jsp as view.so i need to use here ResponseBody annotation. 
		 * whatever the value we return here that will be directly given to the browser in json format.*/
		@ResponseBody
		public String changeLoginStatus(@RequestParam Integer userId,@RequestParam Integer loginStatus){
			try { 
				uService.changeLoginStatus(userId, loginStatus);
				return "SUCCESS: Status Changed Successfully";
				}catch(Exception e) {
				e.printStackTrace();
				return "ERROR: Unable To Change Status";
			}
		}
		@RequestMapping(value = "/check_avail")
		@ResponseBody// This is v imp with these the result will be automatically written in json format instead of finding the jsp view.
		public String checkAvailabitly (@RequestParam String username){
			
				if(uService.isUserNameExist(username)) {
					
					return "These userName is already taken.Choose another Name....!";
					
				}else {
					
					return "Yes..! you can take this";
					
				}
				
			
		}
	
	
//Helper method	
//These user will be added in HttpSession Scope.this will be usefull to identify who is currently loggedIn in the coming pages
private void addUserInSession(Users u,HttpSession session) {
	//user bind to the session
	session.setAttribute("user", u); //binded the complete user here(rare case)
	//we generally required the userid and role to identify who is currently loggedIn the system 
	session.setAttribute("userId", u.getUserId());
	session.setAttribute("role", u.getRole());
}
}
