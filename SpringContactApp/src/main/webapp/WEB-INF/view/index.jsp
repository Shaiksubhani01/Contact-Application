
    <%@ page isELIgnored="false"  %>
    <!--import these to create a form using Spring tag library-->
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login - Contact Application</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css">
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
				<h3>User Login</h3>
			 <c:if test="${err!=null}">
           <p class="error">${err}</p>
        </c:if>
        <!---------------------------------->
        <c:if test="${param.act eq 'lo'}"> <!--so things bind in a url our query String is parameter-->
           <p class="success">Logout Successfully! Thanks for using Contact-Application</p>
        </c:if>
        <!------------------------------------->
        <c:if test="${param.act eq 'reg'}"> <!--so things bind in a url our query String is parameter-->
           <p class="success">User Registered Successfully! Please Login...</p>
        </c:if>
        
        
        
	<!--You have to tell here model attribute which is binding/linking this form with the controller-->
				
			<!--<s:url var="url_login" value="/login" />-->
			
<f:form action="login" modelAttribute="command" method="POST">
    <table border="1">
    
        <tr>
            <td><b>UserName</b></td>
            <td><f:input path="loginName" /></td>
        </tr>
        <tr>
            <td><b>Password</b></td>
            <td><f:password path="password" /></td>
        </tr>
    
        <tr>
            <td colspan="2" align="right">
                <button style="color: green;"><b>Login</b></button> &nbsp;
                	<s:url var="url_reg_form" value="/reg_form"/>
                <a href="${url_reg_form}"><b>New User Registration</b></a>
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