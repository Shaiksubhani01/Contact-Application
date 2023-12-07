package in.ezeon.capp.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.ezeon.capp.domain.Users;

public class UsersRowMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users u = new Users();

		u.setUserId(rs.getInt("userId"));
		u.setName(rs.getString("name"));
		u.setPhone(rs.getString("phone"));
		u.setAddress(rs.getString("address"));
		u.setEmail(rs.getString("email"));
		u.setLoginName(rs.getString("loginName"));
		u.setRole(rs.getInt("role"));
		u.setLoginStatus(rs.getInt("loginStatus"));

		return u;
	}

}
