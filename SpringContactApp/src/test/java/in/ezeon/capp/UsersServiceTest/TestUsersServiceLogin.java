package in.ezeon.capp.UsersServiceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.Users;
import in.ezeon.capp.service.UsersService;

public class TestUsersServiceLogin {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersService uService = ctx.getBean(UsersService.class);
   //the user details will be taken from the User-Reg-Form 
			
			try {
				Users u=uService.login("My3","123456");
				//Users u=uService.login("My","1234");
				//Users u=uService.login(" ","1234");
				System.out.println(u.toString());
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			System.out.println("------------------User retrieve Sucessfully---------------");
			
	}
}
