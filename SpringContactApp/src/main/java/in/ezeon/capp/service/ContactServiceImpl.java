package in.ezeon.capp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import in.ezeon.capp.dao.BaseDao;
import in.ezeon.capp.dao.ContactDao;
import in.ezeon.capp.domain.Contact;
import in.ezeon.capp.rowMapper.ContactRowMapper;
import in.ezeon.capp.util.StringUtil;

@Service
public class ContactServiceImpl extends BaseDao implements ContactService {
	@Autowired
	private ContactDao cdao;

	@Override
	public void save(Contact c) {
		cdao.save(c);

	}

	@Override
	public void update(Contact c) {
		cdao.update(c);

	}

	@Override
	public void delete(Integer contactId) {
		cdao.deleteContactById(contactId);

	}

	@Override
	public void delete(Integer[] contactIds) {
		// i am going create one helper method here to convert these array into comma seperated string.
		String ids = StringUtil.toCommaSeperatedString(contactIds);
		String sql = "DELETE FROM Contact WHERE ContactId IN("+ids+")";
		getJdbcTemplate().update(sql);

	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return cdao.findByProperty("UserId", userId);

	}

	@Override
	public List<Contact> findUserContact(Integer userId, String txt) {
		String FindAll_Sql_Query = "SELECT ContactId,UserId,Name,phone,Email,Address,Remark FROM Contact "
				+ "WHERE UserId=? AND ( name LIKE '%" + txt + "%' OR address LIKE '%" + txt + "%' OR phone LIKE '%"
				+ txt + "%' OR email LIKE '%" + txt + "%' OR remark LIKE '%" + txt + "%')";
		return getJdbcTemplate().query(FindAll_Sql_Query, new ContactRowMapper(), userId);

	}

	@Override
	public Contact findByCid(Integer contactId) {
		return cdao.findById(contactId);
		
	}

}
