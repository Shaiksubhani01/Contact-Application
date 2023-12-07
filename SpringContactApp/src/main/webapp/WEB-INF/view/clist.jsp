<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact List - Contact Application</title>

<link href="static/css/style.css" rel="stylesheet" type="text/css">
</head>
<body style="background-image:url('static/images/bg1.jpg');background-size: cover; ">
	<table border="1" width="50%" align="center">

		<tr>
			<td height="80px">
				<%-- Header--%> <jsp:include page="include/header.jsp" />
			</td>
		</tr>

		<tr>
			<td height="25px">
				<%--Menu--%> <jsp:include page="include/menu.jsp" />
			</td>
		</tr>


		<tr>
			<td height="350px" valign="top">
				<%--Page content area--%> <%--This is a page body For every page these area will be different--%>
				<h3>Contact list</h3>
				<c:if test="${param.act eq 'sv'}"> <!--The value bind in the parameter(query string) is accessable through the param-->
           <p class="success">Contact Saved Successfully</p>
        </c:if>
        <!---------------------------------------------------------------------------->
        <c:if test="${param.act eq 'del'}"> <!--The value bind in the parameter(query string) is accessable through the param-->
           <p class="success">Contact Deleted Successfully</p>
        </c:if>
        <!----------------------------------------------------------------------------->
         <c:if test="${param.act eq 'ed'}"> <!--The value bind in the parameter(query string) is accessable through the param-->
           <p class="success">Contact Edited Successfully</p>
        </c:if> 
        
        <!--adding feild for free-text-search--> <!--action will be created through the spring tag library  -->
				<table width="100%">
					<tr align="center">
						<td>
							<form action="<s:url value="/user/contact_search"/>"
								style="align-content: center">
								<!-- you can add a parameter bocz the key used for seraching is already present in your parameter so you can access through the param.freeText-->
								&nbsp;<input style="width:300px;" type="text" name="freeText"
									value="${param.freeText}" placeholder="Enter text to search" />
								<button style="color: green;">Find</button>
							</form> <br />
						</td>
					</tr>
				</table> 
				
				<!-- i am going to use these alin pattern to create the url -->
                  <form action='<s:url value="/user/bulk_cdelete"/>'>
                  <!--add one button here   -->
                 &nbsp; <button style="color:red;margin-bottom:10px;">Delete Selected Records</button>
                  
				<table border="1" cellpadding="3" style="margin-left: auto; margin-right: auto; margin-bottom:10px;margin-top:auto;">
					<tr >
						<th><b>SELECT</b></th>
						<th><b>CID</b></th>
						<th><b>NAME</b></th>
						<th><b>PHONE</b></th>
						<th><b>ADDRESS</b></th>
						<th><b>EMAIL</b></th>
						<th><b>REMARK</b></th>
						<th><b>ACTION</b></th>
					</tr>
					
					
					<!--If the contactList has no items then you can display here one message using empty check-->
						<c:if test="${empty contactList}"> 
                         <tr>
                         <!-- i am going to merge here columns(8) using colspan attribute-->
                         <td align="center" colspan="8" class="error">No Records are Present</td>
                         </tr>
                       </c:if>
					
					
					<!-- Now we can iterate the data using jstl core librabry-->
						<!-- c stands for contact which is present in your contact list-->
					<!--These st will be use to get the serial Number here-->
					<c:forEach   var="c" items="${contactList}" varStatus="st">
					<tr>
					<!--i am using  common name for all the checkBoxes.
					cid stands for contactId and the value will be dynamically generated through the loop.
					So all the check box will have the common name but their value will be the different-->
						<td align="center"><input type="checkbox" name="cid" value="${c.contactId}"></td>
						<td>${c.contactId}</td>
						<td>${c.name}</td>
						<td>${c.phone}</td>
						<td>${c.address}</td>
						<td>${c.email}</td>
						<td>${c.remark}</td>
						
						<!-- here i am preparing one hyperlink using the url tag-->
						<s:url var="url_del" value="/user/del_contact">
						<!-- i can bind here parameter to these url using these parameter(s:param)-->
						<s:param name="cid" value="${c.contactId}"/>
						</s:url>
						<!---------------->
						<s:url var="url_edit" value="/user/edit_contact">
						<!-- i can bind here parameter to these url using these parameter(s:param)-->
						<s:param name="cid" value="${c.contactId}"/>
						</s:url>
						<td><a href="${url_edit}"  style="color:green;" ><img src="static/images/edits.jpg" width="50" height="50"/>Edit</a>&nbsp;||&nbsp;<a href="${url_del}"  style="color:red;"><img src="static/images/del.png" width="40" height="40"/>Delete</a></td>
					</tr>
					
					
					</c:forEach>
				</table>
				</form>
			</td>
		</tr>

		<tr>
			<td height="25px">
				<%--footer--%> <jsp:include page="include/footer.jsp" />
			</td>
		</tr>


	</table>
</body>
</html>