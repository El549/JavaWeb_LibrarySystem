<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2023/1/2
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div>
    <form action="userLogin" method="post">
        用户Id：<input type="text" name="userId"><br>
        密码：<input type="password" name="userPassword"><br>
        <input type="submit" value="登录">
    </form>

    <a href="userRegister.do">注册</a>
</div>
</body>
</html>
