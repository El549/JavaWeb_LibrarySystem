<%@ page import="java.util.List" %>
<%@ page import="www.zlybl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理页面</title>
</head>
<body>

<table>
    <caption>用户列表</caption>
    <tr>
        <form action="queryUserById" method="post">
            搜索用户<input type="text" name="userId"><input type="submit" value="搜索">
        </form>
    </tr>
    <tr>
        <th>用户Id</th>
        <th>用户名</th>
        <th>用户密码</th>
        <th>操作</th>
    </tr>

    <%
        List<User> userList = (List<User>) request.getAttribute("userList");
        int p= (int) request.getAttribute("p");
        int pageCount= (int) request.getAttribute("pageCount");
        for (User user:userList){
    %>
    <tr>
        <td><%=user.getUserId()%></td>
        <td><%=user.getUserName()%></td>
        <td><%=user.getUserPassword()%></td>
        <td>
            <a href="resetUserPwd?id=<%=user.getUserId()%>">重置密码</a>
            <a href="delUserM?id=<%=user.getUserId()%>">删除用户</a>
        </td>
    </tr>
    <%
        }
    %>
</table>



<%if (p>1){%>
<a href="userList?page=<%=p-1%>">上一页</a>
<%}%>
<%if (p<pageCount){%>
<a href="userList?page=<%=p+1%>">下一页</a>
<%}%>




</body>
</html>
