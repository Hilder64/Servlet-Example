<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 16.03.2019
  Time: 18:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>Имя: <c:out value="${requestScope.user.name}"/></div>
    <div>Возраст: <c:out value="${requestScope.user.age}"/></div>
    <br/>
    <form method="post" action="<c:url value='/update_user'/>">
        <label>Новое имя: <input type="text" name="name" /></label><br>
        <input type="number" hidden name="id" value="${requestScope.user.id}"/>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>
</body>
</html>
