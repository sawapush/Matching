<%-- 
    Document   : loginResult
    Created on : 2017/12/25, 11:36:40
    Author     : g16934os
--%>

<%@page  language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.User" %> 
<%  User loginUser = (User) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>マッチング</title>
    </head>
    <body>
        <h1>ようこそ</h1>
        <% if(loginUser != null) { %> 
        <p>ログインに成功しました</p>
        <p>ようこそ<%= loginUser.getName() %>さん</p>
        <p>あなたの最低希望年収はどのくらいですか？？</p>
        
        <input type="text" name="income">万円以上の！<br>
        <p><a href="/SoftM/Man">男の相手を探す</a></p>
        <p><a href="/SoftM/Woman">女の相手を探す</a></p>
        <a href="/SoftM/allmember">登録者一覧</a>
        
        <% } else { %> 
        <p>ログインに失敗しました</p>
        <a href="/SoftM/Start">TOPへ</a>
        <% } %> 
    </body>
</html>