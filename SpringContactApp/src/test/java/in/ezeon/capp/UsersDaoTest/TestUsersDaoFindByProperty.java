package in.ezeon.capp.UsersDaoTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;

public class TestUsersDaoFindByProperty {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersDao UsersDao = ctx.getBean(UsersDao.class);
     //the user details will be taken from update  User profile page 
			System.out.println("------------------USERS DETAILS-----------------");
			//List<Users>u=UsersDao.findByProperty("UserId",41);
			//List<Users>u=UsersDao.findByProperty("Name","ShaikSamdani");
			List<Users>u=UsersDao.findByProperty("Role",2);
			for(Users e:u) {
				
				//System.out.println(e.getUserId()+" "+e.getName()+" "+e.getRole());
				//accessing other columns
				System.out.println(e);
			}
	}

}
