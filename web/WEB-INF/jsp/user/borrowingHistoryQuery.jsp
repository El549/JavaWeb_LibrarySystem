<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>我的借阅历史</title>
</head>
<body>
<table>
  <caption>借阅历史</caption>
  <tr>
    <th>历史序列</th>
    <th>书ID</th>
    <th>借书用户</th>
    <th>借书时间</th>
    <th>还书时间</th>
  </tr>
  <c:forEach var="history" items="${historyList}" varStatus="s">
    <tr ${s.count%2==1?"style='background-color=#eee'":""}>
      <td>${s.count}</td>
      <td>${history.bookId}</td>
      <td>${history.userId}</td>
      <td>${history.borrowedTime}</td>
      <td>${empty history.returnedTime?"还未还书":history.returnedTime}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
