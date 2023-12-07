package in.ezeon.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import in.ezeon.capp.Exception.UserBlockedException;
import in.ezeon.capp.dao.BaseDao;
import in.ezeon.capp.dao.UsersDao;
import in.ezeon.capp.domain.Users;
import in.ezeon.capp.rowMapper.UsersRowMapper;
@Service
public class UsersServiceImpl extends BaseDao implements UsersService{
    @Autowired
	private UsersDao uDao;
	
    @Override
	public void register(Users u) {
		   uDao.save(u);
		
	}

	@Override
	public Users login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId,name,phone,address,email,role,loginStatus,loginName FROM Users where loginName=:ln AND password=:pw";
		Map<String, Object> m = new HashMap();
		m.put("ln", loginName);
		m.put("pw", password);

		try {
//These query will return a single record always if it is found because you are accessing the data using these loginName and there is only single record bind with the loginName bcoz loginName is a unique
			Users u = getNamedParameterJdbcTemplate().queryForObject(sql, m, new UsersRowMapper());

			if (u.getLoginStatus().equals(UsersService.Login_Status_Blocked)) {
				throw new UserBlockedException("Your account has been blocked.please contact to admin");
			} else {
				
				return u;
			}
		} catch (EmptyResultDataAccessException ex) // so these expection will be thrown when there is no record return by these query 
		{//when there is no record found in database for the given username and password 
			return null;
		}
	}

	@Override
	public List<Users> getUsersList() {
	//i could re-use here findByProeprty() from usersDao which will provide me all the users for role-2(genearl user).
		List<Users> users=uDao.findByProperty("role",UsersService.Role_USER); //Role_USER taking from the constant 
	return users;
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		String update_login_status="UPDATE USERS SET loginStatus=:lST WHERE userId=:uID";
		Map<String, Object> m = new HashMap();
		//bind the parameters here
		m.put("lST", loginStatus);
		m.put("uID",userId);
		//we can get the obj here from the parent class.BaseDao has a method to get the jdbcTemplate obj 
		getNamedParameterJdbcTemplate().update(update_login_status, m);
	}

	@Override
	public boolean isUserNameExist(String userName) {
		String checking_userName_Availability="SELECT COUNT(loginName) FROM users WHERE loginName=?";
		//use JdbcTemplate to execute query 
		Integer count=getJdbcTemplate().queryForObject(checking_userName_Availability, new String[]{userName},Integer.class);
		if(count == 1) {
			return true;
		}else {
			return false;
		}
		
	}

}
