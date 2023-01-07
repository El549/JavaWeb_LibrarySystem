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
    <title>书籍信息</title>
</head>
<body>
<div class="container" style="width: 100%;display: flex; flex-direction: column">
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
        <div class="searchBook0">
            <form action="manager/bookListByConditions" method="post" class="inputForm">
                <div class="inputOut inputOut0">
                    <div class="sbButton addEntry">
                        <button class="inputOut0Add" type="button" onclick="addAuthor()">+</button>
                    </div>
                    <div class="sbButton searchBookButton">
                        <button type="submit" value="搜索" class="inputOut0Search">搜索</button>
                    </div>
                    <span>书名</span>
                    <input name="bookName" type="text" class="inputInput">
                </div>
                <div class="inputOut inputOut1 inputOut11" id="addAuthor">
                    <div class="sbButton addEntry">
                        <button class="inputOut11Add" type="button" onclick="addPress()">+</button>
                    </div>
                    <span>作者</span>
                    <input name="author" type="text" class="inputInput">

                </div>
                <div class="inputOut inputOut1 inputOut12" id="addPress">
                    <div class="sbButton addEntry">
                        <button class="inputOut12Add" type="button" onclick="addClass()">+</button>
                    </div>
                    <span>出版社</span>
                    <input name="press" type="text" class="inputInput">
                </div>
                <div class="inputOut inputOut1 inputOut13" id="addClass">
                    <span>类别</span>
                    <input name="bookClass" type="text" class="inputInput">
                </div>
            </form>
        </div>
        <div class="searchResultBox" style="">
            <div class="searchResults" style="">
                <c:forEach var="book" items="${bookList}" varStatus="s">
                    <div class="row" ${s.count%2==1?"style='background-color=#eee'":""}
                         style="">
                        <div class="col">
                            <div class="srBookCover">
                                <img src="${book.bookCover}">
                            </div>
                            <div class="srRight">
                                <div class="srBookName">
                                    <p class="srBookNameP">${book.bookName}</p>
                                </div>
                                <div class="srBookAuthor">
                                    <p class="srBookAuthorP">${book.author}</p>
                                </div>
                                <div class="srBookPress">
                                    <p class="srBookPressP">${book.press}</p>
                                </div>
                                <div class="srBookStatus">
                                    <p class="srBookStatusP">${book.bookStatus}</p>
                                </div>
                                <div class="srBookClass">
                                    <p class="srBookClassP">${book.bookClass}</p>
                                </div>
                            </div>
                            <div class="srBookOperate">
                                <a href="manager/modBook?bookId=${book.bookId}" style="margin-left: -120px">修改</a>
                                <a href="manager/delBook?bookId=${book.bookId}">删除</a>
                            </div>
                        </div>
                    </div>
                    <div class="bottomLine"></div>
                </c:forEach>
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

<script>
    function addAuthor() {
        document.getElementById("addAuthor").style.display = "block";
    }

    function addPress() {
        document.getElementById("addPress").style.display = "block";
    }

    function addClass() {
        document.getElementById("addClass").style.display = "block";
    }
</script>


</body>
</html>
