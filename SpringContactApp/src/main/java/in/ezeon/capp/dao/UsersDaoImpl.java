package in.ezeon.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import in.ezeon.capp.domain.Users;
import in.ezeon.capp.rowMapper.UsersRowMapper;

@Repository
public class UsersDaoImpl extends BaseDao implements UsersDao {

	@Override
	public void save(Users u) {
		// After insertion, retrieve the generated key using a separate query
		String selectGeneratedKeySQL = "SELECT UserId FROM Users WHERE LoginName= :loginName";

		String sql = "INSERT INTO Users(Name, Phone, Email, Address, LoginName, Password, Role, LoginStatus) "
				+ "VALUES(:name, :phone, :email, :address, :loginName, :password, :role, :loginStatus)";

		Map<String, Object> params = new HashMap<>();
		params.put("name", u.getName());
		params.put("phone", u.getPhone());
		params.put("email", u.getEmail());
		params.put("address", u.getAddress());
		params.put("loginName", u.getLoginName());
		params.put("password", u.getPassword());
		params.put("role", u.getRole());
		params.put("loginStatus", u.getLoginStatus());

		// KeyHolder kh = new GeneratedKeyHolder();

		SqlParameterSource ps = new MapSqlParameterSource(params);

		super.getNamedParameterJdbcTemplate().update(sql, ps);

		// Execute the query to retrieve the generated key
		SqlParameterSource keyParams = new MapSqlParameterSource("loginName", u.getLoginName());
		Number generatedKey = super.getNamedParameterJdbcTemplate().queryForObject(selectGeneratedKeySQL, keyParams,
				Integer.class);

		int uId = generatedKey.intValue();
		u.setUserId(uId);
		System.out.println("UserId::" + u.getUserId());
	}

	@Override
	public void update(Users u) {
		String Update_sql_query = "UPDATE USERS SET Name=:name,Phone=:phone,Email=:email,Address=:address,Role=:role, LoginStatus=:loginStatus WHERE UserId=:userId";

		Map<String, Object> params = new HashMap<>();
		params.put("name", u.getName());
		params.put("phone", u.getPhone());
		params.put("email", u.getEmail());
		params.put("address", u.getAddress());
		params.put("role", u.getRole());
		params.put("loginStatus", u.getLoginStatus());
		params.put("userId", u.getUserId());

		getNamedParameterJdbcTemplate().update(Update_sql_query, params);

	}

	@Override
	public void delete(Users u) {
		this.deleteUserById(u.getUserId());

	}

	@Override
	public void deleteUserById(Integer userId) {
		String delete_sql_query = "DELETE FROM Users WHERE userId=?";
		getJdbcTemplate().update(delete_sql_query, userId);
	}

	@Override
	public Users findById(Integer userId) {
		String FindById_Sql_Query = "SELECT UserId,Name,Phone,Email,Address,LoginName,LoginStatus,Role FROM Users WHERE UserId=?";
		Users u = getJdbcTemplate().queryForObject(FindById_Sql_Query, new UsersRowMapper(), userId);
		return u;
	}

	@Override
	public List<Users> findAll() {
		String FindAll_Sql_Query = "SELECT UserId,Name,phone,Email,Address,LoginName,LoginStatus,Role FROM Users";
		List<Users> u = getJdbcTemplate().query(FindAll_Sql_Query, new UsersRowMapper());
		return u;
	}

	@Override
	public List<Users> findByProperty(String propName, Object propValue) {
		String FindByProperty_Sql_Query = "SELECT UserId,Name,phone,Email,Address,LoginName,LoginStatus,Role FROM Users WHERE "+propName+"=?";
		List<Users> u = getJdbcTemplate().query(FindByProperty_Sql_Query, new UsersRowMapper(),propValue);
		return u;
	}

}
