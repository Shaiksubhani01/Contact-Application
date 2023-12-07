package in.ezeon.capp.ContactDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;


public class TestContactDaoSave {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			ContactDao cDao=ctx.getBean(ContactDao.class);
			Contact c=new Contact();
			c.setName("shaik mahamoodh");
			c.setUserId(4);
			c.setAddress("nellore");
			c.setEmail("shaik@gmail.com");
			c.setPhone("8186880849");
			c.setRemark("nice");
			cDao.save(c);		
			System.out.println("------------------DATA SAVED---------------");
			
	}

}
