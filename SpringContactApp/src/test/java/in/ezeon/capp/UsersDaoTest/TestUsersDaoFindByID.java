package in.ezeon.capp.UsersDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;

public class TestUsersDaoFindByID {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersDao UsersDao = ctx.getBean(UsersDao.class);
     //the user details will be taken from update  User profile page 
			Users u=UsersDao.findById(4);
			System.out.println("------------------USER DETAILS---------------");
			/*System.out.println(u.getUserId());
			System.out.println(u.getName());
			System.out.println(u.getPhone());
			System.out.println(u.getAddress());
			System.out.println(u.getEmail());
			System.out.println(u.getLoginName());
			System.out.println(u.getLoginStatus());
			System.out.println(u.getRole());*/
			System.out.println(u);
	}

}
