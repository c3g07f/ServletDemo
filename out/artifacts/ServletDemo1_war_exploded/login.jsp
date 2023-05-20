<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/12
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="/css/login.css">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="/js/jquery.js"></script>
<head>
    <title>登录</title>
</head>
<body   style="background:url('/image/1.png');background-repeat:no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div class="container1 ">
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" class="tbx" placeholder="账号" name="username">
        <input type="password" class="tbx" placeholder="密码" name="password">
        <input type="submit" class="sub" value="登录">
    </form>
</div>
    </body>
</html>