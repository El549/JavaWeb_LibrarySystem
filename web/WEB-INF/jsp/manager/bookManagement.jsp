<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>书籍信息</title>
</head>
<body>
<a href="addBook.do">添加图书</a><br>
<form action="bookListByConditions" method="post">
    书名:<input name="bookName" type="text">
    作者:<input name="author" type="text">
    出版社:<input name="press" type="text">
    小说类别:<input name="bookClass" type="text">
    <input type="submit" value="搜索">
</form>
<table>
    <caption>书籍信息表</caption>
    <tr>
        <th>书籍序列</th>
        <th>图片</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>类型</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach var="book" items="${bookList}" varStatus="s">
        <tr ${s.count%2==1?"style='background-color=#eee'":""}>
            <td>${s.count}</td>
            <td><img src="${book.bookCover}" height="100px" width="100px" alt="书籍图片加载失败"></td>
            <td>${book.bookName}</td>
            <td>${book.author}</td>
            <td>${book.press}</td>
            <td>${book.bookClass}</td>
            <td>${book.bookStatus}</td>
            <td><a href="modBook?bookId=${book.bookId}">修改</a> <a href="delBook?bookId=${book.bookId}">删除</a></td>
        </tr>
    </c:forEach>
</table>
<%
    int p= (int) request.getAttribute("p");
    int pageCount= (int) request.getAttribute("pageCount");
%>
<%if (p>1){%>
<a href="bookList?page=<%=p-1%>">上一页</a>
<%}%>
<%if (p<pageCount){%>
<a href="bookList?page=<%=p+1%>">下一页</a>
<%}%>
</body>
</html>
