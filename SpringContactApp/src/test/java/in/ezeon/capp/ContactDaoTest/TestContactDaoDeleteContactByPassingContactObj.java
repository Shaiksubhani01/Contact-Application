package in.ezeon.capp.ContactDaoTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;

public class TestContactDaoDeleteContactByPassingContactObj {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
		  ContactDao cDao=ctx.getBean(ContactDao.class);
			Contact c=new Contact();
			c.setContactId(2);
			cDao.delete(c);
			
			
			System.out.println("------------DATA DELETED BY TAKING THE CONTACT OBJECT AS ARG---------------");
			
	}

}
