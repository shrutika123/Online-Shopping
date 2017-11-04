<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">

<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';
	
	window.contextRoot = '${contextRoot}'
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- bootstrap simplex theme CSS -->
<link href="${css}/bootstrap_readable_theme.css" rel="stylesheet">

<!-- bootstrap data table -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">

		<!-- Navigation -->

		<%@include file="./shared/navbar.jsp"%>


		<!-- page content -->

		<div class="content">

			<!-- loading the home content -->

			<c:if test="${userClickHome == true }">
				<%@include file="home.jsp"%>
			</c:if>

			<!-- load when only clicks about -->
			<c:if test="${userClickAbout == true }">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- load when only clicks Contact-->
			<c:if test="${userClickContact == true }">
				<%@include file="contact.jsp"%>
			</c:if>

			<!-- load when only clicks Contact-->
			<c:if
				test="${userClickAllProducts == true or userClickCategoryProducts == true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
			
			<!-- load only when clicks show product-->
			<c:if
				test="${userClickShowProduct == true }">
				<%@include file="singleProduct.jsp"%>
			</c:if>
			
			<!-- load only when clicks manage product-->
			<c:if
				test="${userClickManageProducts == true }">
				<%@include file="manageProducts.jsp"%>
			</c:if>
			
			<!-- load only when clicks manage product-->
			<c:if
				test="${userClickShowCart == true }">
				<%@include file="cart.jsp"%>
			</c:if>
			
			

		</div>

		<!-- Footer -->

		<%@include file="./shared/footer.jsp"%>

		<!-- JQUEY -->
		<script src="${js}/jquery.js"></script>
		
		<!-- JQUEY  VALIDATION-->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		

		<!-- DataTable plugin -->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- DataTable bootstrap script -->
		<script src="${js}/dataTables.bootstrap4.js"></script>
		
		<!--bootbox -->
		<script src="${js}/bootbox.min.js"></script>
		

		<!-- self codede javascript -->
		<script src="${js}/myapp.js"></script>

	</div>

</body>

</html>
