<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>修改书籍信息</title>
</head>
<body>

<form action="modBook" method="post">
    书籍ID:<input name="bookId" type="text" value="${book.bookId}" readonly><br>
    书籍图片信息地址:<input name="bookCover" type="text" value="${book.bookCover}"><br>
    书名:<input name="bookName" type="text" value="${book.bookName}"><br>
    作者:<input name="author" type="text" value="${book.author}"><br>
    出版社:<input name="press" type="text" value="${book.press}"><br>
    小说类别:<input name="bookClass" type="text" value="${book.bookClass}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
