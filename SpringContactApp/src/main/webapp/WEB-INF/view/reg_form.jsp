    <%@ page isELIgnored="false"  %>
    <!--import these to create a form using Spring tag library-->
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration - Contact Application</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css">

<!-- i am going to integrate the jquery library with these page by adding the below code-->
<s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
<script src="${url_jqlib}"></script>

<script>

//below i am using the anonymous function()
$(document).ready(function(){
//Now register a event for that check availability button.find by id we can use here and write one function in click when click time fired.
	$("#id_check_avail").click( function(){
		//when someone click on the button(check Availability) a rq we have to send to server which is a ajax rq.so call these ajax function.
		
		$.ajax({
			//pass here arguments 
			url : 'check_avail',
			// username will be read from the field and that will be bind to your rq.
			data : {username: $("#id_userName").val()},
			success : function(data){
				//these response i have to place into div using div id. 
				$("#id_res_div").html(data);
			}
		});
	 });
});


</script>
</head>
<body style="background-image:url('static/images/bg1.jpg');background-size: cover; ">
	<table border="1" width="50%" align="center">

		<tr>
			<td height="80px">
				<%-- Header--%>
				<jsp:include page="include/header.jsp"/>
			</td>
		</tr>

		<tr>
			<td height="25px">
				<%--Menu--%>
				<jsp:include page="include/menu.jsp"/>
			</td>
		</tr>


		<tr>
			<td height="350px" valign="top">
				<%--Page content area--%>
				<%--This is a page body For every page these area will be different--%>
				<h3>User Registration</h3>
			 <c:if test="${err!=null}">
           <p class="error">${err}</p>
        </c:if>
        
	<!--You have to tell here model attribute which is binding/linking this form with the controller-->
				
			<!-- <s:url var="url_reg" value="/register" />-->
<!-- here you can use through the modelAttribute command  -->
<f:form action="register" modelAttribute="command" method="POST">
    <table border="1">
    <!--here we have to use user.loginName bcoz Username is not directly the part of the UserCommand but it is part of the Users object.
    so inside the command you have to go into the Users then you can accesss the Users related properties.This is the trick you can follow here-->
       
        <tr>
            <td><b>Name</b></td>
            <td><f:input path="user.name" /></td>
        </tr>
         <tr>
            <td><b>Phone</b></td>
            <td><f:input path="user.phone" /></td>
        </tr>
         <tr>
            <td><b>Email</b></td>
            <td><f:input path="user.email" /></td>
        </tr>
         <tr>
            <td><b>Address</b></td>
            <td><f:textarea path="user.address" /></td>
        </tr>
       
        <tr>
            <td><b>UserName</b></td>
            <td>
            <!-- here i am using id to get the value from the below field  -->
            <f:input id="id_userName" path="user.loginName" />
            <!-- add check availabity button to check loginName availability -->
            <button type="button" id="id_check_avail" style="color:blue;"><b>Check Availabity</b></button>
            <!--when the user click on the above button a rq will be send to the server.
            if the userName is available you have to display the message below and
             if the userName is not available you have to display the error message below using div-->
             <div id="id_res_div" class="error"></div>
            </td>
        </tr>
        <tr>
            <td><b>Password</b></td>
            <td><f:password path="user.password" /></td>
        </tr>
             
        <tr>
            <td colspan="2" align="right">
            <button style="color: red;"><b>reset</b></button>&nbsp;
                <button style="color: green;"><b>Submit</b></button> 
              
            </td>
        </tr>
    </table>
</f:form>
			</td>
		</tr>

		<tr>
			<td height="25px">
				<%--footer--%>
				<jsp:include page="include/footer.jsp"/>
			</td>
		</tr>


	</table>
</body>
</html>