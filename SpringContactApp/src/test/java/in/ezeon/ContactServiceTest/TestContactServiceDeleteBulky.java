package in.ezeon.ContactServiceTest;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

public class TestContactServiceDeleteBulky {
	public static void main(String[] args) {
		  @SuppressWarnings("resource")
			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
			
			
			ContactService cService = ctx.getBean(ContactService.class);
   //the contact details will be taken from the User-Reg-Form 
			Integer[] arr= {22,3}; 
			cService.delete(arr);	
			System.out.println("------------------ Multiple Contacts Deleted Sucessfully---------------");
			
	}
}
