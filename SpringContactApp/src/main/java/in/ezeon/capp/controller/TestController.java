package in.ezeon.capp.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
	@RequestMapping("/test/hello")
	public String HelloWorld() {
		return "hello"; //  WebApp/WEB-INF/view/hello.jsp
	}
	
	@RequestMapping("/test/ajax_test")
	public String testPage() {
		return "test"; //  WebApp/WEB-INF/view/hello.jsp
	}
	
	//when you request get_time you will get the server time
	/*
	 Note:-Generally this method return value is your view name but here these date will not be your view.
	 The value returned by these method will be directly route in output stream instead of finding any jsp page(view).
	 so generally these return  value is a jsp as per the spring Mvc Standard
	  but i want these value to be directly route in output Stream for these we are using a small tag.
*/
	@RequestMapping("/test/get_time")
	@ResponseBody //these tag(@ResponseBody) will write the output directly in your output stream.
	public String getServerTime() {
		System.out.println("--------------getServerTime()--------------------");
		Date d=new Date();
	
		return d.toString(); //  WebApp/WEB-INF/view/test.jsp
	}


}
