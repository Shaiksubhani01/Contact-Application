package in.ezeon.capp.UsersDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;

public class TestUsersDaoDeleteByPassingObj {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			UsersDao UsersDao = ctx.getBean(UsersDao.class);
            Users u=new Users();
	        u.setUserId(1);
	        
	
			UsersDao.delete(u);
			System.out.println("------------DATA DELETED BY TAKING THE OBJECT---------------");
			
	}

}
