package in.ezeon.capp.ContactDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;


public class TestContactDaoFindContactById {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			ContactDao cDao=ctx.getBean(ContactDao.class);
			System.out.println("------------------FETCHING DATA---------------");
			
			Contact c=cDao.findById(3);
			/*System.out.println(c.getContactId());
		   System.out.println(c.getUserId());
			System.out.println(c.getName());
			System.out.println(c.getPhone());
			System.out.println(c.getEmail());
			System.out.println(c.getRemark());
			System.out.println(c.getAddress());*/
			System.out.println(c);
			
	}

}
