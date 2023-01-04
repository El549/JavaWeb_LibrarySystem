<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>我的借还申请</title>
</head>
<body>
<table>
<caption>借还申请</caption>
<tr>
    <th>申请序号</th>
    <th>用户id</th>
    <th>书籍ID</th>
    <th>申请类型</th>
    <th>申请状态</th>
</tr>
<c:forEach var="apply" items="${applyList}" varStatus="s">
    <tr>
        <td>${s.count}</td>
        <td>${apply.userId}</td>
        <td>${apply.bookId}</td>
        <td>${apply.applyType}</td>
        <td>${apply.applyStatus}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
