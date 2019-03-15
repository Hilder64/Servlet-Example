<%--
  Created by IntelliJ IDEA.
  User: aleks
  Date: 15.03.2019
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Title</title>
  </head>
  <body>

  <h1>Heil mine friend!</h1><br />

  <h2>Все пользователи</h2><br />

  <c:forEach var="user" items="${requestScope.users}">
      <ul>
          <li>Имя: <c:out value="${user.name}"/></li>
          <li>Возраст: <c:out value="${user.age}"/></li>
      </ul>
      <hr/>
  </c:forEach>

  <h2>Создание нового пользователя</h2><br/>

  <form method="post" action=""><%--index.jsp--%>

      <label><input type="text" name="name"></label>Имя<br/>
      <label><input type="text" name="age"></label>Возраст<br/>

      <input type="submit" value="Ok" name="Ok"><br/>

  </form>

  </body>
</html>
