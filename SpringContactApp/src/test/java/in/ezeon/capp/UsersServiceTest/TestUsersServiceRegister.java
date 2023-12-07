package in.ezeon.capp.UsersServiceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;
import in.ezeon.capp.service.UsersService;

public class TestUsersServiceRegister {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersService uService = ctx.getBean(UsersService.class);
   //the user details will be taken from the User-Reg-Form 
			Users u=new Users();
			u.setName("Urs");
			u.setPhone("7997845826");
			u.setEmail("ssubhanishaik123@gmail.com");
			u.setAddress("udaygiri");
			u.setLoginName("My");
			u.setPassword("1234");
			u.setRole(uService.Role_ADMIN);//admin-role(1)
			u.setLoginStatus(uService.Login_status_Active);//active(1)
			uService.register(u);
			System.out.println("------------------User Registered Sucessfully---------------");
			
	}
}
