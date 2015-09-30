<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<sql:query var="location" dataSource="jdbc/myapp">
    select id, name from location;
</sql:query>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users List</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>id</th>
                <th>name</th>
            </tr>
            <c:forEach var="location" items="${location.rows}">
                <tr>
                    <td><c:out value="${location.id}" /></td>
                    <td><c:out value="${location.name}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>