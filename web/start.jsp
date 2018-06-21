<%-- 
    Document   : start
    Created on : 2017/12/25, 11:17:47
    Author     : g16934os
--%>

<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="servlet.LoginServlet" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>マッチング</title>
    </head>
    <body>
        <h1>ようこそ</h1>
        <form action="/SoftM/LoginServlet" method="post">
            ユーザー名:<input type="text" name="name"><br>
            パスワード:<input type="password" name="pass"><br>
            <input type="submit" value="ログイン"><br>
            <a href="/SoftM/Touroku">初めての方</a>
            
        </form>
    </body>
</html>
