<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <base href="/javaweb_library_system/">
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
          crossorigin="anonymous">

    <!--  我的css   -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mycss.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mysidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mynavbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bookListSearch.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/searchPage.css">
    <title>修改书籍信息</title>
</head>
<body>
<div class="container" style="width: 100%">
    <div class="container_1" id="container_1" style="width: 100%">
        <div class="upShadow" id="upShadow" style="width: 100%">
        </div>
        <div class="upShadowIn row">
            <p class="prName col-auto">图书管理系统</p>
            <p class="framer col">@**小组作品</p>
        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="navbar">
            <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/static/img/logo1.png"
                                                  style="width: 80%"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                    aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarText" style="color: white;">
                <ul class="navbar-nav mr-auto" style="margin-bottom: -10px">
                    <li class="nav-item active">
                        <a class="nav-link" href="manager/managerHome.do" style="">
                            <img src="${pageContext.request.contextPath}/static/img/首页.png"
                                 style="width: 15%;margin-top: -6px;">
                            首页
                        </a>
                    </li>
                    <li class="nav-item" style="margin-left: -100px">
                        <a class="nav-link" href="manager/managerLogout">
                            <img src="${pageContext.request.contextPath}/static/img/退出登录.png"
                                 style="width: 10%;margin-top: -6px;">
                            退出登录
                        </a>

                    </li>
                </ul>
                <span class="navbar-text">
                        立身以立学为先，立学以读书为本。
                    </span>
            </div>
        </nav>
    </div>
    <div class="searchBookOut">
        <div class="searchResultBox" style="width: 100%;text-align: center;">
            <div class="searchResults"
                 style="width: 60%;margin: auto;background-color: rgba(255,255,255,0.8);padding-bottom: 100px">
                <div class="row"
                     style="">
                    <div class="col" style="text-align:center;">
                        <div class="modBookInfo"  style="width: 60%;margin: auto;padding: 40px 0;">
                            <form action="manager/modBook" method="post">
                                <p>书籍ID:<input style="margin: 10px;" name="bookId" type="text" value="${book.bookId}" readonly></p>
                                <p>书籍图片信息地址:<input name="bookCover" type="text" value="${book.bookCover}"></p>
                                <p>书名:<input name="bookName" type="text" value="${book.bookName}"></p>
                                <p>作者:<input name="author" type="text" value="${book.author}"></p>
                                <p>出版社:<input name="press" type="text" value="${book.press}"></p>
                                <p>小说类别:<input name="bookClass" type="text" value="${book.bookClass}"></p>
                                <input type="submit" value="修改">
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!--        <div style="position: absolute; width: 100%; top: 90%; background: linear-gradient(to bottom)">-->

    <!--        </div>-->
</div>
</div>

<!-- jQuery 和 Bootstrap 集成包（集成了 Popper） -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>


</body>
</html>
