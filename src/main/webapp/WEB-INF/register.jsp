<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<h1>Register</h1>
<div>
    <form action="<c:url value="/register"/> " method="post">
        <div>First Name: <input type="text" name="firstName"/> </div>
        <div>Last Name: <input type="text" name="lastName"/> </div>
        <div>Login: <input type="text" name="login"/> </div>
        <div>Password: <input type="password" name="password"/> </div>
        <button type="submit">Register</button>
    </form>
</div>
</body>
</html>
