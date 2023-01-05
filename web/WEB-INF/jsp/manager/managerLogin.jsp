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
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/managerLogin.css">
    <title>managerLogin</title>
</head>
<body>
<div class="backImg">
    <div class="container">
        <div class="div-form">
            <form action="managerLogin" method="post" class="mlogin">
                <h1>mLogin</h1>
                <input type="text" name="managerId" placeholder="帐号">
                <input type="password" name="managerPassword" placeholder="密码">
                <button type="submit">Login</button>
                <div class="managerLogin">
                    <span>切换<a href="../user/userLoginPage">用户登录</a></span>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>