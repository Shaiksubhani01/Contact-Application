    <%@ page isELIgnored="false"  %>
    <!--import these to create a form using Spring tag library-->
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form - Contact Application</title>
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
				<h3><b>Contact Form</b></h3>
			 <c:if test="${err!=null}">
           <p class="error">${err}</p>
        </c:if>
        
	<!--You have to tell here model attribute which is binding/linking this form with the controller-->
				
			 <s:url var="url_csave" value="/user/save_contact"/>
<!-- here you can use through the modelAttribute command  -->
<f:form action="${url_csave}" modelAttribute="command" method="POST">
    <table border="1">
       <!--These all are the command properties so we have added here contact domain class as a command  where all these properties are there-->
        <tr>
            <td><b>Name</b></td>
            <td><f:input path="name" /></td>
        </tr>
         <tr>
            <td><b>Phone</b></td>
            <td><f:input path="phone" /></td>
        </tr>
         <tr>
            <td><b>Email</b></td>
            <td><f:input path="email" /></td>
        </tr>
         <tr>
            <td><b>Address</b></td>
            <td><f:textarea path="address" /></td>
        </tr>
       
        <tr>
            <td><b>Remark</b></td>
            <td><f:textarea path="remark" /></td>
        </tr>
       
             
        <tr>
            <td colspan="2" align="center">
            
            <button style="color: red;"><b>reset</b></button>&nbsp;
                <button style="color: green;"><b>save</b></button> 
              
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