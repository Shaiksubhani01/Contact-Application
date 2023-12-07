package in.ezeon.capp.service;

import java.util.List;

import in.ezeon.capp.domain.Contact;

//The interface specifies all business operation for contact entity.
public interface ContactService {
	public void save(Contact c);

	public void update(Contact c);

	public void delete(Integer contactId);
	
	public Contact findByCid(Integer contactId);

//For multipe deletion
	public void delete(Integer[] contactIds);

//These method will returns all user contact(user who is logged in).
	public List<Contact> findUserContact(Integer userId);

	/*
	 * Here the user account will be search using these given string criteria(free-text searching)
	 * 
	 * These method will search contact for user(userId) based on given free-text-criteria(txt).
	 * 
	 * @param userId User who is logged in.
	 * 
	 * @param txt criteria use to serach - free text search criteria
	 */
	public List<Contact> findUserContact(Integer userId, String txt);
}
