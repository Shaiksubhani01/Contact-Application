package in.ezeon.capp.dao;

import java.util.List;

import in.ezeon.capp.domain.Users;

public interface UsersDao {
	public void save(Users u);

	public void update(Users u);

	public void delete(Users u);

	public void deleteUserById(Integer userId);

	public Users findById(Integer userId);

	public List<Users> findAll();

	public List<Users> findByProperty(String propName, Object propValue);// column name,column value
}
