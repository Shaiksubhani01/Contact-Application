package in.ezeon.capp.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
//Note:-do not use @Repository/@Service/@Component Annotation bcoz this is not going to independently exist in your container
abstract public class BaseDao extends NamedParameterJdbcDaoSupport {
	
//setter Injection	
	@Autowired
	public void setDataSource2(DataSource ds) {
		super.setDataSource(ds);

	}

}
