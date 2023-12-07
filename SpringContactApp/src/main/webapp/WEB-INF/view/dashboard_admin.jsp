<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin DashBoard - Contact Application</title>
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
				<h1>Admin Dashboard</h1>
				TOD0:Admin options in these page 
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