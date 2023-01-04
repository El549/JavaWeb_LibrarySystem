<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<form action="addBook" method="post">
    书籍图片信息地址:<input name="bookCover" type="text" ><br>
    书名:<input name="bookName" type="text"><br>
    作者:<input name="author" type="text"><br>
    出版社:<input name="press" type="text"><br>
    小说类别:<input name="bookClass" type="text"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
