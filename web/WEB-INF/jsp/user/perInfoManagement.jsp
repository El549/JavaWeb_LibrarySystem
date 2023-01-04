<%@ page import="www.zlybl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<h1>XXX的个人信息</h1>
<%
    User user= (User) request.getAttribute("user");
%>
<form action="modUserInfo" method="post" >
    用户名:<input name="userId" type="text" value="<%=user.getUserId()%>" readonly><br>
    用户名:<input name="userName" type="text" value="<%=user.getUserName()%>"><br>
    密码:<input name="userPassword" type="password" value="<%=user.getUserPassword()%>"><br>
    <input type="submit" value="修改">
</form>

<a href="delUser?id=<%=user.getUserId()%>">删除用户</a>
</body>
</html>
