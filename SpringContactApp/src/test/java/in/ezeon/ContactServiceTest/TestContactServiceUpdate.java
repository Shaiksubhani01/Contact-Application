package in.ezeon.ContactServiceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

public class TestContactServiceUpdate {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			ContactService cService = ctx.getBean(ContactService.class);
   //the contact details will be taken from the User-Reg-Form 
			Contact c=new Contact();
			c.setContactId(21);
			c.setName("lovely");
			c.setPhone("7997845826");
			c.setEmail("ssubhanishaik123@gmail.com");
			c.setAddress("kadapa");
			c.setRemark("very nice");
			cService.update(c);		
			System.out.println("------------------Contact Updated Sucessfully---------------");
			
	}
}
