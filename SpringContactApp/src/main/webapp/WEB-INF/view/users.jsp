    <%@ page isELIgnored="false"  %>
    <!--import these to create a form using Spring tag library-->
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List - Contact Application</title>
<link href="static/css/style.css" rel="stylesheet" type="text/css">

<!-- i am going to integrate the jquery library with these page by adding the below code-->
<s:url var="url_jqlib" value="/static/js/jquery-3.2.1.min.js"/>
<script src="${url_jqlib}"></script>

<script>

function changeStatus(uId,lStatus){
	//alert(userId+","+loginStatus);
	//i am going to generate a ajax call here
	$.ajax({
		//here u have to specify the controllerMethod-url in url.and these controllerMethod-url will take/carry these two parameters.
		url:'change_status',
		//bind values with the request using(data)
	data:{userId:uId,loginStatus:lStatus},
		//these two are the parameters(userId,loginStatus)for the above url.
		success : function(data){
			//This(data)is the result send by the controller method.
			alert(data);
		}
	});
}



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
				<h3>User List</h3>
			 <table border="1" cellpadding="3" style="margin-left: auto;margin-right: auto;">
					<tr>
						<th>SR</th>
						<th>USERID</th>
						<th>NAME</th>
						<th>PHONE</th>
						<th>EMAIL</th>
						<th>ADDRESS</th>
						<th>USERNAME</th>
						<th>STATUS</th>
					</tr>
                <!-- i can use here a tag-library-->
                <!-- u(users) and the users will be taken form the userList  -->
                <!-- these st will help me to identify the serial Number -->
           <c:forEach var="u" items="${userList}" varStatus="st">
<tr>
						<td>${st.count}</td>
						<td>${u.userId}</td>
						<td>${u.name}</td>
						<td>${u.phone}</td>
						<td>${u.email}</td>
						<td>${u.address}</td>
						<td>${u.loginName}</td>
						<td>
						<!-- place one combo box here with 2 options-->	
						<!--when the user change the action from browser like active to block/block to active then 
						the value will be updated in server automatically instead of using database tool bcoz
						 these value will be automatically updated from the userInterface not from the database tool.
						 Now i am going to generate a ajax call here and that ajax call will send internal-rq 
						 to the server and server will update that through the controller -->
						 <!--Now to update the status we required here change event and i will pass two values 1:updated-status and 2:userId -->
						<select id="id_${u.userId}" onchange="changeStatus(${u.userId}, $(this).val())">
                          <option value="1" style="color:green;">Active</option>
                           <option value="2" style="color: red;">Block</option>
                         </select>
						<!-- when the status is present here "2" the 2nd option must be selected.
						it should be always the blocked option should be selected when the page is displayed here-->
						
						<!--Now i am going to use a small jquery code to make these above item selected-->
						<script>
						// Now i have to make the above combo box selected according to the value present in status 
						//note:-You can get the object of any field,any element by id through these "#"
						$('#id_${u.userId}').val(${u.loginStatus});
						</script>
						</td>
					</tr>
              </c:forEach>
				</table>
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