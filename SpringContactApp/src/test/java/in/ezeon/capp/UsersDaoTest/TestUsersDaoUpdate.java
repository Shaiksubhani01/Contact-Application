package in.ezeon.capp.UsersDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;

public class TestUsersDaoUpdate {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersDao UsersDao = ctx.getBean(UsersDao.class);
     //the user details will be taken from update  User profile page 
			Users u=new Users();
			u.setUserId(1);
			u.setName("shaik.subhani");
			u.setPhone("8186880849");
			u.setEmail("Ssubhanishaik1@gmail.com");
			u.setAddress("kavali");
			u.setRole(1);//admin-role(1)
			u.setLoginStatus(1);//active(1)
			UsersDao.update(u);
			System.out.println("------------------DATA UPDATED---------------");
			
	}

}
