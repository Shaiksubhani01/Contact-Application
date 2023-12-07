 <%@ page isELIgnored="false"  %>
 <%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- i will add here jquery and some events i need  to add here.-->
<!-- you need to pass here src and so these will your spring url.i need to use here spring tag-lib -->
<s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
<!-- testing for to know properly integrated or not -->
<script src="${url_jqlib}"></script>


<script>
/*
 *The below i am calling a function when these event is fired and 
 these is the anonymous function will be called here when the page is ready to display. 
 so i am going to display the below alert.  
 */
 
$(document).ready(function(){
	//alert('JQuery is ready and integerated successfully');
	//its time to register one  event to these button.
	
	/* The below "$" represents jquery obj and i am going to select these button and 
	now add one event here click() and when you click on get server time button a function will be called here it is anonymous function.*/
	$("#id_get_time").click(function(){
	//alert('Button Clicked....');
	//here i am going to use Ajax($.ajax() function i am using here)
	$.ajax({
		// Now write here multiple values
		url : 'get_time',
		success : function (data){
			$("#id_time").html(data);
		}
	    });
	});
});

</script>



<title>Jsp-page</title>
</head>
<body>
	<h1>Ajax Test Page</h1>
	<!-- i am going to add here one button.when you click on these button we will get the server time -->
	<button id="id_get_time">Get Server Time </button></br>
	
	<!--whatever the time return by  server without refreshing the page i will get detail from the server 
	which is the time and i will print that time(result) here in these below paragraph  -->
	<p id="id_time"></p>
	
</body>
</html>