<%@ page import="java.util.List" %>
<%@ page import="www.zlybl.model.Book" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: lhy
  Date: 2023/1/3
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户书籍全查</title>
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
        <form action="bookListByConditionsU" method="post">
            <tr>
                <td><input name="" type="text"></td>
                <td><input name="bookName" type="text"></td>
                <td><input name="author" type="text"></td>
                <td><input name="press" type="text"></td>
                <td><input name="bookClass" type="text"></td>
                <td><input name="bookStatus" type="text"></td>
                <td><input type="submit"value="搜索"></td>
            </tr>
        </form>
        <%
            List<Book> bookList = (List<Book>) request.getAttribute("bookList");
            int p = (int)request.getAttribute("p");
            int pageCount = (int) request.getAttribute("pageCount");
            for (Book book : bookList){
        %>
        <tr>
            <td><img src="<%=book.getBookCover()%>" height="120px"></td>
            <td><%=book.getBookName()%></td>
            <td><%=book.getAuthor()%></td>
            <td><%=book.getPress()%></td>
            <td><%=book.getBookClass()%></td>
            <td><%=book.isBookStatus()%></td>
            <c:if test="<%=!book.isBookStatus()%>">
                <td>
                    被借
                </td>
            </c:if>
            <c:if test="<%=book.isBookStatus()%>">
                <td>
                    <a href="applyForLoan?bookId=<%=book.getBookId()%>&userId=${user.userId}">申请借阅</a>
                </td>
            </c:if>
        </tr>
        <%
            }
        %>
    </table>
    <%if (p > 1) {%>
    <a href="bookListU?page=<%=p-1%>">上一页</a>
    <%}%>
    <%if (p < pageCount) {%>
    <a href="bookListU?page=<%=p+1%>">下一页</a>
    <%}%>
</body>
</html>
