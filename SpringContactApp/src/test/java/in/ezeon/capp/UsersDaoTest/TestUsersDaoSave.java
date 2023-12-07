package in.ezeon.capp.UsersDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;

public class TestUsersDaoSave {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersDao UsersDao = ctx.getBean(UsersDao.class);
     //the user details will be taken from the User-Reg-Form 
			Users u=new Users();
			u.setName("shaik123");
			u.setPhone("9951564573");
			u.setEmail("ssubhanishaik1@gmail.com");
			u.setAddress("Nellore");
			u.setLoginName("My3");
			u.setPassword("123456");
			u.setRole(1);//admin-role(1)
			u.setLoginStatus(1);//active(1)
			UsersDao.save(u);
			System.out.println("------------------DATA SAVED---------------");
			
	}

}
