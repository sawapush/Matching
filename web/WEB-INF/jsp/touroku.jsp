<%-- 
    Document   : touroku
    Created on : 2018/01/11, 11:48:08
    Author     : g16934os
--%>

<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="servlet.Start" %>
<%String errorMsg = (String) request.getAttribute("errorMsg"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>マッチング</title>
    </head>
    <body>
        <h1>新規登録</h1>
        <form action="/SoftM/Start" method="post">
            <p>氏名：<input type="text" name="name"></p>
            <p>年齢：<input type="text" name="age"></p>
            <p>年収：<input type="text" name="income">万円</p>
            <p>性別：<input type="text" name="sex"></p>
            <p>(男性＝０/女性＝１)</p>
            <p>ここの共通パスワードは「1234」です</p>
            
            <input type="submit" value="登録"><br>
        </form>
        
        <% if(errorMsg != null) { %>
        <p><%= errorMsg %></p>
        <% } %>
        
    </body>
</html>
