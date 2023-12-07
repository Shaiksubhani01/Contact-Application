package in.ezeon.capp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.rowMapper.ContactRowMapper;
@Repository
public class ContactDaoImpl extends BaseDao implements ContactDao{

	@Override
	public void save(Contact c) {
		// After insertion, retrieve the generated key using a separate query
		String selectGeneratedKeySQL = "SELECT ContactId FROM Contact WHERE Phone=:phone";
		String sql = "INSERT INTO CONTACT(UserId,Name,Phone,Email,Address,Remark)VALUES(:userId,:name,:phone,:email,:address,:remark)";
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("userId", c.getUserId());
		m.put("name", c.getName());
		m.put("phone", c.getPhone());
		m.put("email", c.getEmail());
		m.put("address", c.getAddress());
		m.put("remark", c.getRemark());

		SqlParameterSource ps = new MapSqlParameterSource(m);
		super.getNamedParameterJdbcTemplate().update(sql, ps);

		// Execute the query to retrieve the generated key
		SqlParameterSource keyParams = new MapSqlParameterSource("phone", c.getPhone());
		Number generatedKey = super.getNamedParameterJdbcTemplate().queryForObject(selectGeneratedKeySQL, keyParams,
				Integer.class);

		int cId = generatedKey.intValue();
		c.setContactId(cId);
		System.out.println("contactId::" + c.getContactId());
	}

	@Override
	public void update(Contact c) {
		String Update_sql_query = "UPDATE Contact SET Name=:name,Phone=:phone,Email=:email,Address=:address,Remark=:remark WHERE ContactId=:contactId";

		Map<String, Object> params = new HashMap<>();
		params.put("name", c.getName());
		params.put("phone", c.getPhone());
		params.put("email", c.getEmail());
		params.put("address", c.getAddress());
		params.put("remark", c.getRemark());
		params.put("contactId", c.getContactId());

		getNamedParameterJdbcTemplate().update(Update_sql_query, params);
	}

	@Override
	public void delete(Contact c) {
		this.deleteContactById(c.getContactId());
	}

	@Override
	public void deleteContactById(Integer contactId) {
		String delete_sql_query = "DELETE FROM Contact WHERE ContactId=?";
		getJdbcTemplate().update(delete_sql_query, contactId);

	}

	@Override
	public Contact findById(Integer contactId) {
		String FindById_Sql_Query = "SELECT ContactId,UserId,Name,Email,Address,phone,Remark FROM Contact WHERE ContactId=?";
		Contact c = getJdbcTemplate().queryForObject(FindById_Sql_Query, new ContactRowMapper(),contactId);
		return c;
	}

	@Override
	public List<Contact> findAll() {
		String FindAll_Sql_Query = "SELECT ContactId,UserId,Name,phone,Email,Address,Remark FROM Contact";
		List<Contact> c = getJdbcTemplate().query(FindAll_Sql_Query, new ContactRowMapper());
		return c;
	}

	@Override
	public List<Contact> findByProperty(String propName, Object propValue) {
		String FindByProperty_Sql_Query = "SELECT ContactId,UserId,Name,phone,Email,Address,Remark FROM Contact WHERE "
				+ propName + "=?";
		List<Contact> c = getJdbcTemplate().query(FindByProperty_Sql_Query, new ContactRowMapper(), propValue);
		return c;
	}

}
