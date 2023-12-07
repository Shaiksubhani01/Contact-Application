<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>



<!--preparing url for logout-->
<s:url var="url_logout" value="/logout"/>

<c:if test="${sessionScope.userId == null}">
	<!-- user is not yet loggedIn : Guest Menu-->
	<s:url var="url_reg_form" value="/reg_form"/>
	<a href="#">Home</a> | <a href="#">Login</a> |<a href="${url_reg_form}">Register</a> |<a
		href="#">About</a> |<a href="#">Help</a>
</c:if>
<!-- ---------------------------------------------------------  -->
<!--preparing urls-->
<s:url var="url_ulist" value="/admin/users"/>

<c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
	<!-- Admin is loggedIn : Admin Menu-->
	<a href="#">Home</a> | <a href="${url_ulist}">User List</a> |<a href="${url_logout}">Logout</a>
</c:if>
<!-- ---------------------------------------------------------  -->

<c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
<!--preparing urls-->
<s:url var="url_uhome" value="/user/dashboard"/>
<s:url var="url_cform" value="/user/contact_form"/>
<s:url var="url_clist" value="/user/clist"/>
	<!-- General User is loggedIn : User Menu-->
	<a href="${url_uhome}">Home</a> | <a href="${url_cform}">Add Contact</a>| <a href="${url_clist}">Contact
		List</a> |<a href="${url_logout}">Logout</a>
</c:if>