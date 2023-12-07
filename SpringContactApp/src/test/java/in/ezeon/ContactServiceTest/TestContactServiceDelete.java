package in.ezeon.ContactServiceTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

public class TestContactServiceDelete {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			ContactService cService = ctx.getBean(ContactService.class);
   //the contact details will be taken from the User-Reg-Form 
			
			
			cService.delete(21);	
			System.out.println("------------------Contact Deleted Sucessfully---------------");
			
	}
}
