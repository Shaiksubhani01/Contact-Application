package in.ezeon.capp.UsersDaoTest;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import in.ezeon.capp.config.SpringRootConfig;

public class TestDataSource {
        
    	public static void main(String[] args) {
  			  @SuppressWarnings("resource")
  			ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
  			DataSource ds = ctx.getBean(DataSource.class);
  			JdbcTemplate jt = new JdbcTemplate(ds);
  			String sql = "INSERT INTO Users (Name,Phone,Email, Address,LoginName,Password)VALUES(?,?,?,?,?,?)";
  			  Object[] params = new Object[] {"ShaikSamdani", "8985037927", "Shaik6@gmail.com", "kamativariStreetKavali", "samdhani", "s123"};
  			jt.update(sql,params);
  		
  			System.out.println("-------------SQL EXECUTED--------------");

  		}           
      
}