package in.ezeon.capp.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.ezeon.capp.domain.Contact;

public class ContactRowMapper implements RowMapper<Contact> {

	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact c = new Contact();

		c.setContactId(rs.getInt("ContactId"));
		c.setUserId(rs.getInt("UserId"));
		c.setName(rs.getString("Name"));
		c.setEmail(rs.getString("Email"));
		c.setAddress(rs.getString("Address"));
		c.setPhone(rs.getString("phone"));
		c.setRemark(rs.getString("Remark"));

		return c;
	}

}
