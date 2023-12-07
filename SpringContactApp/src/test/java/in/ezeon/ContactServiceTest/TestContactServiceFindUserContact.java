package in.ezeon.ContactServiceTest;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

public class TestContactServiceFindUserContact {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			ContactService cService = ctx.getBean(ContactService.class);
   //the contact details will be taken from the User-Reg-Form 
			
			List<Contact> c=cService.findUserContact(4)	;
			for(Contact temp:c) {
				System.out.println(temp.getName());
				System.out.println(temp.getContactId());
				System.out.println(temp.getAddress());
				System.out.println(temp.getPhone());
			}
			System.out.println("------------------ Contact Finded Sucessfully---------------");
			
	}
}
