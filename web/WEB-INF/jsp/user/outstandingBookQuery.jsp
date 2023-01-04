<%@ page import="www.zlybl.model.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lhy
  Date: 2023/1/4
  Time: 05:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户图书查询页面</title>
</head>
<body>
<table>
  <caption>图书列表</caption>
  <tr>
    <th>封面</th>
    <th>书名</th>
    <th>作者</th>
    <th>出版社</th>
    <th>类型</th>
    <th>状态</th>
    <th>操作</th>
  </tr>
  <%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
    for (Book book : bookList){
  %>
  <tr>
    <td><img src="<%=book.getBookCover()%>" height="120px"></td>
    <td><%=book.getBookName()%></td>
    <td><%=book.getAuthor()%></td>
    <td><%=book.getPress()%></td>
    <td><%=book.getBookClass()%></td>
    <td><%=book.isBookStatus()%></td>
    <td>
      <a href="applyForReturn?bookId=<%=book.getBookId()%>&userId=${user.userId}">申请归还</a>
    </td>
  </tr>
  <%
    }
  %>
</table>
</body>
</html>
