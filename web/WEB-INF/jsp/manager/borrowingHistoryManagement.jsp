<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>借阅历史</title>
</head>
<body>
<form action="HistoryListByUserId" method="post">
    用户id:<input name="userId" type="text">
    <input type="submit" value="搜索">
</form>
<table>
    <caption>借阅历史</caption>
    <tr>
        <th>历史序列</th>
        <th>书Id</th>
        <th>借书用户</th>
        <th>借书时间</th>
        <th>还书时间</th>
    </tr>
    <c:forEach var="history" items="${historyList}" varStatus="s">
        <tr ${s.count%2==1?"style='background-color=#eee'":""}>
            <td>${s.count}</td>
            <td>${history.bookId}</td>
            <td>${history.userId}</td>
            <td>${history.borrowingTime}</td>
            <td>${empty history.returnedTime?"还未还书":history.returnedTime}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
