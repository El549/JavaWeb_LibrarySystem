<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2023/1/3
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>
<body>
<div>
    <p>Registration successful!</p>
    <p>your ID is ${user.userId}</p>
    <p>your name is ${user.userName}</p>
    <%
        session.removeAttribute("user");
        session.invalidate();
    %>
    <a href="userLoginPage">回到登陆页面</a>
</div>
</body>
</html>
