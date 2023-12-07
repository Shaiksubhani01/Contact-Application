package in.ezeon.capp.ContactDaoTest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;

public class TestContactDaoFindAll {

	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
		  ContactDao cDao=ctx.getBean(ContactDao.class);
			System.out.println("------------------FETCHING DATA---------------");
			List<Contact> c =cDao.findAll();
			for(Contact e:c) {
				
				//System.out.println(e.getContactId()+" "+e.getUserId()+" "+e.getName());
				//accessing other columns
				System.out.println(e);
			}
	}

}
