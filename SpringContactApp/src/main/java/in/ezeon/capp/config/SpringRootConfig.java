package in.ezeon.capp.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages ={"in.ezeon.capp.dao","in.ezeon.capp.service"})
@Configuration
public class SpringRootConfig{
//ToDo: service,Dao,Datasouce,Email Sender or some other business layer kind of beans we have to register here
	@Bean
	public BasicDataSource getDatasource() {
		
		BasicDataSource bds=new BasicDataSource();
		    bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		    bds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		    bds.setUsername("ContactApp");
		    bds.setPassword("contactapp");
		bds.setMaxTotal(2);
		bds.setInitialSize(1);
		bds.setTestOnBorrow(true);
		bds.setValidationQuery("SELECT 1 FROM DUAL");
		bds.setDefaultAutoCommit(true);//BY default the query will be commited
		return bds;
	}
  
	
}
