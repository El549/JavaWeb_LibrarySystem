<%@ page import="java.util.List" %>
<%@ page import="www.zlybl.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>用户管理</title>

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
        <div class="searchBook0">
            <form action="manager/queryUserById"  method="post" class="inputForm">
                <div class="inputOut inputOut0">
                    <div class="sbButton searchBookButton" style="right: 0;border-bottom-right-radius: 32px;border-top-right-radius: 32px">
                        <button type="submit" value="搜索" class="inputOut0Search">搜索</button>
                    </div>
                    <span>用户ID</span>
                    <input name="userId" type="text" class="inputInput">
                </div>
            </form>
        </div>
        <div class="searchResultBox" style="width: 100%;text-align: center;height: 500px;">
            <div class="searchResults" style="width: 60%;margin: auto;background-color: rgba(255,255,255,0.8)">
                    <div class="row" ${s.count%2==1?"style='background-color=#eee'":""}
                         style="">
                        <div class="col" style="text-align: center">
                            <table class="userTable" style="width:90%;margin: auto;padding: 20px 20px">
                                <tr>
                                    <th>用户Id</th>
                                    <th>用户名</th>
                                    <th>用户密码</th>
                                    <th>操作</th>
                                </tr>

                                <%
                                    List<User> userList = (List<User>) request.getAttribute("userList");
                                    int p= (int) request.getAttribute("p");
                                    int pageCount= (int) request.getAttribute("pageCount");
                                    for (User user:userList){
                                %>
                                <tr>
                                    <td><%=user.getUserId()%></td>
                                    <td><%=user.getUserName()%></td>
                                    <td><%=user.getUserPassword()%></td>
                                    <td>
                                        <a href="resetUserPwd?id=<%=user.getUserId()%>">重置密码</a>
                                        <a href="delUserM?id=<%=user.getUserId()%>">删除用户</a>
                                    </td>
                                </tr>
                                <%
                                    }
                                %>
                            </table>
                            <%if (p>1){%>
                            <a href="manager/userList?page=<%=p-1%>">上一页</a>
                            <%}%>
                            <%if (p<pageCount){%>
                            <a href="manager/userList?page=<%=p+1%>">下一页</a>
                            <%}%>
                        </div>
                    </div>
            </div>
        </div>

    </div>
    <!--        <div style="position: absolute; width: 100%; top: 90%; background: linear-gradient(to bottom)">-->

    <!--        </div>-->
    <div class="footer" style="top: 90%">
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

</body>
</html>
