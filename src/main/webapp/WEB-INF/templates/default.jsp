
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:set var="myContext" value="${pageContext.request.contextPath}"/>

<tiles:insertAttribute name="header"></tiles:insertAttribute>
<script
	src="${myContext}/static/vendor/jquery/jquery.js"></script>
<script
	src="${myContext}/static/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
<script
	src="${myContext}/static/vendor/bootstrap/js/bootstrap.js"></script>
<script
	src="${myContext}/static/vendor/nanoscroller/nanoscroller.js"></script>
<script
	src="${myContext}/static/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
<script
	src="${myContext}/static/vendor/magnific-popup/magnific-popup.js"></script>
<script
	src="${myContext}/static/vendor/jquery-placeholder/jquery.placeholder.js"></script>

<!-- Specific Page Vendor -->
<script src="http://maps.google.com/maps/api/js?sensor=false"></script>
<script
	src="${myContext}/static/vendor/gmaps/gmaps.js"></script>

<!-- Theme Base, Components and Settings -->
<script
	src="${pageContext.request.contextPath}/static/javascripts/theme.js"></script>

<!-- Theme Custom -->
<script
	src="${pageContext.request.contextPath}/static/javascripts/theme.custom.js"></script>

<!-- Theme Initialization Files -->
<script
	src="${pageContext.request.contextPath}/static/javascripts/theme.init.js"></script>


<!-- Examples -->
<script
	src="${pageContext.request.contextPath}/static/javascripts/maps/examples.gmap.js"></script>


</head>
<body>
	<div class="content">
		<tiles:insertAttribute name="sidebar"></tiles:insertAttribute>

		<tiles:insertAttribute name="content"></tiles:insertAttribute>
	</div>
	<tiles:insertAttribute name="footer"></tiles:insertAttribute>

</body>
</html>