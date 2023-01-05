<%--
  Created by IntelliJ IDEA.
  User: Hao
  Date: 2023/1/2
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- 必须的 meta 标签 -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <base href="/javaweb_library_system/">
    <!-- Bootstrap 的 CSS 文件 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" crossorigin="anonymous">

    <!--  我的css   -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mycss.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mysidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/mynavbar.css">
    <title>欢迎您，管理员</title>
</head>
<body>

<a id="openSidebar" class="openSidebar" onclick="open_sidebar()">
    <img src="${pageContext.request.contextPath}/static/img/菜单.svg">
</a>
<div class="mySidebar" id="mySidebar">
    <a id="label2" class="closeSidebar" onclick="close_sidebar()">
        <img src="${pageContext.request.contextPath}/static/img/叉号.svg">
    </a>
    <br>
    <br>
    <div class="bar-item">
        <a class="col-auto" href="manager/bookList">书籍管理</a>
        <a class="col-auto">&gt;</a>
    </div>
    <div class="bar-item">
        <a class="col-auto" href="manager/userList">用户管理</a>
        <a class="col-auto">&gt;</a>
    </div>
    <div class="bar-item">
        <a class="col-auto" href="manager/borrowingHistoryList">借阅历史</a>
        <a class="col-auto">&gt;</a>
    </div>
    <div class="bar-item">
        <a class="col-auto" href="manager/loanApplyList">借书申请</a>
        <a class="col-auto">&gt;</a>
    </div>
    <div class="bar-item">
        <a class="col-auto" href="manager/returnApplyList">还书申请</a>
        <a class="col-auto">&gt;</a>
    </div>
    <div class="" style="position: absolute; bottom: 20%;left: -2%">
        <svg t="1672229906770" class="icon" viewBox="0 0 1170 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
             p-id="17467" width="200" height="200">
            <path d="M507.201829 25.044114c18.929371 0 34.523429 14.394514 36.395885 32.855772l0.175543 3.715657v905.157486h-73.142857V98.186971h-89.000229v868.586058h-73.142857V61.615543c0-18.929371 14.394514-34.523429 32.855772-36.366629l3.744914-0.2048h162.113829z"
                  fill="rgba(90,194,238,0.4)" p-id="17468"></path>
            <path d="M462.701714 206.584686v350.237257h-73.142857V206.613943zM903.168 1002.642286l173.992229-31.597715a36.571429 36.571429 0 0 0 29.403428-42.715428L966.626743 182.564571a36.571429 36.571429 0 0 0-42.481372-29.198628l-173.992228 31.597714a36.571429 36.571429 0 0 0-29.403429 42.715429l139.936915 745.764571a36.571429 36.571429 0 0 0 42.481371 29.198629z m124.7232-96.987429l-102.019657 18.549029-126.390857-673.821257 101.9904-18.549029 126.420114 673.821257z"
                  fill="rgba(90,194,238,0.4)" p-id="17469"></path>
            <path d="M921.951086 424.023771l55.296 294.590172-71.8848 13.487543-55.296-294.590172zM264.689371 325.749029v73.142857H156.584229v-73.142857zM264.689371 416.5632v73.142857H156.584229v-73.142857zM264.689371 503.222857v73.142857H156.584229v-73.142857z"
                  fill="rgba(90,194,238,0.4)" p-id="17470"></path>
            <path d="M264.689371 195.437714v73.142857H129.024v635.026286h-73.142857V232.0384c0-18.958629 14.394514-34.523429 32.855771-36.395886l3.744915-0.175543h172.207542zM1149.015771 926.281143v73.142857H0v-73.142857z"
                  fill="rgba(90,194,238,0.4)" p-id="17471"></path>
            <path d="M779.527314 414.573714c18.958629 0 34.523429 14.365257 36.395886 32.826515l0.175543 3.715657v515.657143h-73.142857V487.687314h-155.530972v-73.142857h192.1024z"
                  fill="rgba(90,194,238,0.4)" p-id="17472"></path>
            <path d="M728.707657 519.168h-156.613486v246.052571h156.613486v-246.052571z m-73.172114 73.1136v99.796114h-10.298514v-99.796114h10.298514z"
                  fill="rgba(90,194,238,0.4)" p-id="17473"></path>
        </svg>
    </div>
</div>


<div class="container">
    <div class="container_1" id="container_1">
        <div>
            <div class="upShadow" id="upShadow">
            </div>
            <div class="upShadowIn row">
                <p class="prName col-auto">图书管理系统</p>
                <p class="framer col">@**小组作品</p>
            </div>
            <nav class="navbar navbar-expand-lg navbar-light bg-light" id="navbar">
                <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/static/img/logo1.png" style="width: 80%"></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText"
                        aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarText" style="color: white;">
                    <ul class="navbar-nav mr-auto" style="margin-bottom: -10px">
                        <li class="nav-item active">
                            <a class="nav-link" href="manager/managerHome.do" style="">
                                <img src="${pageContext.request.contextPath}/static/img/首页.png" style="width: 15%;margin-top: -6px;">
                                首页
                            </a>
                        </li>
                        <li class="nav-item" style="margin-left: -100px">
                            <a class="nav-link" href="manager/managerLogout">
                                <img src="${pageContext.request.contextPath}/static/img/退出登录.png" style="width: 10%;margin-top: -6px;">
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
        <div class="slideshows" id="main">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="${pageContext.request.contextPath}/static/img/3.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/2.jpg" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="${pageContext.request.contextPath}/static/img/1.jpg"
                             class="d-block w-100" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev slideshowsButtons" type="button"
                        data-target="#carouselExampleIndicators"
                        data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </button>
                <button class="carousel-control-next slideshowsButtons" type="button"
                        data-target="#carouselExampleIndicators"
                        data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </button>
            </div>
        </div>
        <div class="searchBoxesContainer">
            <div class="searchBoxes row">
                <div class="searchBox1 searchBox col">
                    <p class="searchMethod sm1">图书搜索</p>
                    <div class="searchInputBox">
                        <form action="manager/bookListByConditions" method="post">
                            <input name="bookName" type="text" placeholder="书名">
                            <button class="search" type="submit">
                                <img src="${pageContext.request.contextPath}/static/img/搜索.svg">
                            </button>
                        </form>
                    </div>
                    <a class="searchIntro" href="#" onclick="none;">查阅指南 ></a>
                    <a class="searchIntro" href="#" onclick="none;">查询以管理图书 >></a>
                </div>
                <div class="searchBox2 searchBox col">
                    <p class="searchMethod sm2">用户搜索</p>
                    <div class="searchInputBox">
                        <form action="manager/queryUserById" method="post">
                            <input name="userId" type="text" placeholder="用户ID">
                            <button class="search" type="submit">
                                <img src="${pageContext.request.contextPath}/static/img/搜索.svg">
                            </button>
                        </form>
                    </div>
                    <a class="searchIntro" href="#" onclick="none;">查阅指南 ></a>
                    <a class="searchIntro" href="#" onclick="none;">查询以管理用户 ></a>

                </div>
                <div class="searchBox2 searchBox col">
                    <p class="searchMethod sm2">借阅记录查询</p>
                    <div class="searchInputBox">
                        <form action="manager/historyListByUserId" method="post">
                            <input name="userId" type="text" placeholder="">
                            <button class="search" type="submit">
                                <img src="${pageContext.request.contextPath}/static/img/搜索.svg">
                            </button>
                        </form>
                    </div>
                    <a class="searchIntro" href="#" onclick="none;">查阅指南 ></a>
                    <a class="searchIntro" href="#" onclick="none;">搜索图书或用户的借阅记录 >></a>
                </div>

            </div>
        </div>
        <!--        <div style="position: absolute; width: 100%; top: 90%; background: linear-gradient(to bottom)">-->

        <!--        </div>-->
        <div class="footer">
            <div class="footerLeft">
                <div class="footerLeftInner">
                    <img src="${pageContext.request.contextPath}/static/img/logo.jpg">
                    <p>地址(Adr)：成都市成洛大道2025号 </p>
                    <p>电话(Tel)：028-84616118　邮编(Zip Code)：610106</p>
                </div>

            </div>
            <div class="footerRight">
                <div class="footerRightInner">
                    <img src="${pageContext.request.contextPath}/static/img/qrcode-lightblue.png">
                    <p>© 成都大学 All Rights Reserved</p>
                    <p>© Chengdu University</p>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- jQuery 和 Bootstrap 集成包（集成了 Popper） -->
<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/myJs.js"></script>

</body>
</html>
