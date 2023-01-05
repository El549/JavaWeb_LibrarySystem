<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2023/1/2
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
</head>
<body>
<div>
        <form action="managerLogin" method="post">
            用户名：<input type="text" name="managerName" ><br>
            密码：<input type="password" name="managerPassword" ><br>
            <input type="submit" value="登录">
        </form>
</div>
</body>
</html>
