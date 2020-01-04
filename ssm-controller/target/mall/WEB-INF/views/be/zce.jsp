<%--
  Created by IntelliJ IDEA.
  User: LW
  Date: 2019/12/16
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <meta charset="UTF-8">
    <!--<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">-->
    <title>注册页面</title>
    <link rel="stylesheet" type="text/css" href="/static/css/style.css">
    <link rel="stylesheet" type="text/css" href="/static/css/body.css">

</head>


<body>
<div class="container">
    <section id="content">
        <form action="/be/login" method="post">
            <h1>欢迎来到注册页面</h1>
            <div>
                <input type="text" placeholder="账号" required="" id="username">
            </div>
            <div>
                <input type="password" placeholder="密码" required="" id="password">
            </div>
            <div class="">
                <span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>			</div>
            <div>

                <input type="submit" value="注册" class="btn btn-primary" id="js-btn-login1">
                <a href="/be/login">已有账号返回</a>
            </div>
        </form><!-- form -->


    </section><!-- content -->
</div>
<!-- container -->
</body>

</html>
