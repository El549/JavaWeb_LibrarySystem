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
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/userLoginAndRegister.css">
    <title>userLoginAndRegister</title>
</head>
<body>
<div>
    <div class="backImg">
        <div class="container">
            <div class="div-description">
                <img src="${pageContext.request.contextPath}/static/img/loginBook.svg" alt="">
<%--                <span>图片加载失败~</span>--%>
            </div>
            <div class="div-form">
                <form action="userLogin" method="post" class="form-login">
                    <h1>uLogin</h1>

                    <input type="text" name="userId" placeholder="帐号">
                    <input type="password" name="userPassword" placeholder="密码">
                    <button type="submit">Login</button>

                    <div class="control">
                    <span>没有帐号？
                        <a href="#">Register</a>
                    </span>
                    </div>

                    <div class="managerLogin">
                        <span>切换<a href="../manager/managerLoginPage">管理员登录</a></span>
                    </div>
                </form>

                <form action="userRegister" method="post" class="form-register disappear">
                    <h1>uRegister</h1>
                    <input type="text" name="userName" placeholder="帐号">
                    <input type="password" name="userPassword" placeholder="密码">
                    <button type="submit">Register</button>

                    <div class="control">
                        <span>已有帐号？<a href="userLogin.do">Login</a></span>
                    </div>

                </form>
            </div>
            <div class="div-description">
                <img src="${pageContext.request.contextPath}/static/img/registerBook.png" alt="">
                <%--                <span>图片加载失败~</span>--%>
            </div>
        </div>
    </div>

    <script>
        var btn = document.querySelectorAll('.control a')
        var formContainer = document.querySelector('.div-form')
        var form = document.querySelectorAll('.div-form form')

        // 切换注册
        btn[0].addEventListener('click', function (e) {
            form[0].classList.add('disappear')
            form[1].classList.remove('disappear')
            formContainer.style.transform = 'rotateY(180deg)'
        })
        // 切换登录
        btn[1].addEventListener('click', function (e) {
            form[1].classList.add('disappear')
            form[0].classList.remove('disappear')
            formContainer.style.transform = 'none'
        })
    </script>
</div>
</body>
</html>
