package in.ezeon.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.service.ContactService;

@Controller
public class ContactController {
	//we have to add here interfaces not implementation class.the spring ioc container will supply the implementation here internally. 
	
	@Autowired
	private ContactService cservice;
	// i am going to categorize all the user role based urls under these user category 
	@RequestMapping(value="/user/contact_form")
	public String contactForm(Model m) {
		//here bind your command  
		// i am re-using here these contact Domain class as my command 
		Contact contact=new Contact();
		m.addAttribute("command",contact); // bind here  
		return"contact_form"; //JSP form view 
	}
	
	
	
	
	//we need to get the value which is send through the query String
	@RequestMapping(value="/user/edit_contact")
	public String prepareEditForm(Model m,HttpSession session,@RequestParam("cid") Integer contactId) {
		session.setAttribute("aContactId", contactId); //binded cId in session scope
	 
		Contact c=cservice.findByCid(contactId);
		m.addAttribute("command",c);   /* these contact obj added in your model which is nothing but as a command.
		so i am re-using my contact obj as a command and this will be presented by these view*/
		return"contact_form"; //JSP form view 
	}
	
	
	
	
	
	
	
	/*we have to access the command through the model Attribute.
	we will recieve here command and these command has complete data which is entered in your new contact form.
	these contact obj has the detail entered in your  form and you can pass these contact to the service layer which will take care the saving part */
	@RequestMapping(value="/user/save_contact")
	public String saveOrUpdateContact(@ModelAttribute("command") Contact c,Model m,HttpSession session) {
		/* we need to specify the user bcoz the contact is a child entity and you need to specify these contact belongs to a certain user.
		 (who is the user,where these contact belongs) The person who has logged-in in your system and that user you need to access here using HttpSession 
		 */
		//down casting
		Integer contactId=(Integer) session.getAttribute("aContactId");
		if(contactId == null){
			//save Task
			try {
				Integer userId=(Integer)session.getAttribute("userId");
				c.setUserId(userId);//fk is a logged-In userId.without these we cannot identify the where these contact belongs/in which user acc these contact will be added.
				cservice.save(c);
				return"redirect:clist?act=sv"; //redirect user to contact list url
				}catch(Exception e) {
					e.printStackTrace();
					m.addAttribute("err","Failed to save Contact");
					return "contact_form";
				}
		}else {
			//update Task
			try {
				c.setContactId(contactId);// without pk you cannot do the update 
				cservice.update(c);
				return"redirect:clist?act=ed"; //redirect user to contact list url
				}catch(Exception e) {
					e.printStackTrace();
					m.addAttribute("err","Failed to Edit Contact");
					return "contact_form";
				}
			
			
		}
	}
	
	
	
	// i need to get the value entered in a search-form(@RqP)
	@RequestMapping(value="/user/contact_search")
	public String contactSearch(Model m,HttpSession session,@RequestParam("freeText") String freeText) {
		/*we need to pass here userId for that we need to access userId from HttpSession.
		it will provide who is the currently loggedIn user and who is the recent user that userId you can get it from the session.*/
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactList",cservice.findUserContact(userId,freeText)); //The result will be added in your request-scope internally and these will be accessable from your jsp page.
		return"clist"; //JSP form view 
	}
	
	
	
	
	
	@RequestMapping(value="/user/clist")
	public String contactList(Model m,HttpSession session) {
		/*we need to pass here userId for that we need to access userId from HttpSession.
		it will provide who is the currently loggedIn user and who is the recent user that userId you can get it from the session.*/
		Integer userId=(Integer)session.getAttribute("userId");
		m.addAttribute("contactList",cservice.findUserContact(userId));
		return"clist"; //JSP form view 
	}
	@RequestMapping(value="/user/del_contact")
	//we will recieve here contactId.The contact is bind through cid parameter 
	public String deleteContact(@RequestParam("cid") Integer contactId) {
	           cservice.delete(contactId);
		return"redirect:clist?act=del"; //binded a flag here
	}
	
	@RequestMapping(value="/user/bulk_cdelete")
	/*we will recieve here contactIds.multiple values are bind to these common cid
	 .so these time these cid will be your array and you can  pass this to a method(delete(Integer[] contactIds)).*/ 
	public String deleteBulkContact(@RequestParam("cid") Integer[] contactIds) {
		cservice.delete(contactIds);
		return "redirect:clist?act=del"; // binded a flag here
	}
	
	

}
