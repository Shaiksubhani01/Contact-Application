package in.ezeon.capp.ContactDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;


public class TestContactDaoUpdate {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			ContactDao cDao=ctx.getBean(ContactDao.class);
			Contact c=new Contact();
			c.setName("shaik mahamood");
			c.setAddress("kavali,524201");
			c.setEmail("shaik143@gmail.com");
			c.setPhone("+919951564573");
			c.setRemark("Nice");
			c.setContactId(1);
			cDao.update(c);		
			System.out.println("------------------DATA UPDATED---------------");
			
	}

}
