<%@ page import="www.zlybl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/managerLogin.css">
    <title>个人信息</title>
</head>
<body>
    <div class="backImg">
        <div class="container">
            <div class="div-form">
                <form action="modUserInfo" method="post" class="mlogin">
                    <%
                        User user= (User) request.getAttribute("user");
                    %>
                    <h1>个人信息:<%=user.getUserId()%></h1>
<%--                    用户id:<input type="text" name="userId" value="<%=user.getUserId()%>" readonly style="display: inline">--%>
                    用户名:<input type="text" name="userName" value="<%=user.getUserName()%>" style="display: inline">
                    密码:<input type="password" name="userPassword" value="<%=user.getUserPassword()%>" style="display: inline">
                    <button type="submit">修改</button>
                    <div class="managerLogin">
                        <span><a href="delUser?id=<%=user.getUserId()%>">注销账号！</a></span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
