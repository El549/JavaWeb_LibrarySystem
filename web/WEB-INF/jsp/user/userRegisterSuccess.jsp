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
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/managerLogin.css">
    <title>注册成功</title>
</head>
<body>
<div class="backImg">
    <div class="container">
        <div class="div-form">
            <div class="mlogin">
                <h1>Success</h1>
                <div class="successText">
                    <p>Registration successful!</p><br>
                    <p>Your ID is:
                    <p class="rUserId">${user.userId}</p></p><br>
                    <p>Your name is:
                    <p class="rUserName">${user.userName}</p></p>
                    <%
                        session.removeAttribute("user");
                        session.invalidate();
                    %>
                </div>
                <div class="managerLogin" style="margin-top: 20px">
                    <span>回到<a href="userLoginPage">登录页面</a></span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
