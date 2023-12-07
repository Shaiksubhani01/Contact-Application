package in.ezeon.capp.dao;

import java.util.List;

import in.ezeon.capp.domain.Contact;

public interface ContactDao {

	public void save(Contact c);

	public void update(Contact c);

	public void delete(Contact c);

	public void deleteContactById(Integer contactId);

	public Contact findById(Integer contactId);

	public List<Contact> findAll();

	public List<Contact> findByProperty(String propName, Object propValue);// column name,column value
}
