<%@ page import="www.zlybl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户个人信息管理</title>
</head>
<body>

<table>
    <tr>
        <form action="queryUserById" method="post">
            搜索用户<input type="text" name="userId"><input type="submit" value="搜索">
        </form>
    </tr>
    <tr>
        <th>用户Id</th>
        <th>用户名</th>
        <th>用户密码</th>
    </tr>

    <%
        User user= (User) request.getAttribute("user");
    %>
    <tr>
        <td><%=user.getUserId()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getUserPassword()%></td>
    </tr>
</table>
<table>
    <tr>
        <td>
            <a href="resetUserPwd?id=<%=user.getUserId()%>">重置密码</a>
            <a href="delUserM?id=<%=user.getUserId()%>">删除用户</a>
        </td>
    </tr>
</table>



</body>
</html>
