package in.ezeon.capp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackages = {"in.ezeon.capp"})
//This will activate your mvc configuration or mvc module 
@EnableWebMvc 
public class SpringWebConfig extends WebMvcConfigurerAdapter{
	
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//The contents present in location static will be accessable on the webpage from the static.
	registry.addResourceHandler("/static/**").addResourceLocations("/static/");
	  registry.addResourceHandler("/admin/static/**").addResourceLocations("/static/");
	  registry.addResourceHandler("/user/static/**").addResourceLocations("/static/");

	super.addResourceHandlers(registry);
}
@Bean
public ViewResolver viewResolver() {
	InternalResourceViewResolver vr= new InternalResourceViewResolver();
	vr.setViewClass(JstlView.class);
	vr.setPrefix("/WEB-INF/view/");
	vr.setSuffix(".jsp");
	// return the viewresolver here 
	return vr;
	
}

}
