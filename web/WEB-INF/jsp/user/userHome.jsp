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
    <title>图书管理系统-用户</title>
</head>
<body>
<div>
    <a href="modUserInfo">个人信息管理</a>
    <a href="bookListU">书籍查询</a>
    <a href="outstandingBookList">未还书籍查询</a>
    <a href="">借阅历史查询</a>
    <a href="">申请记录查询</a>
    <a href="userLogout">退出登录</a>
    ${user.userName}
</div>
</body>
</html>
