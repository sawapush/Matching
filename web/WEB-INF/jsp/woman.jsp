<%-- 
    Document   : woman
    Created on : 2018/01/15, 12:38:18
    Author     : g16934os
--%>

<%@page import="java.util.List"%>
<%@page import="model.MutterW"%>
<%@page import="model.User"%>
<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% // セッションスコープに保存されたユーザー情報を取得 
    User loginUser = (User) session.getAttribute("loginUser");
    List<MutterW>mutterListW = (List<MutterW>) request.getAttribute("mutterListW");
    String errorMsg = (String) request.getAttribute("errorMsg");
%>
<%//@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>マッチング</title>
    </head>
    <body>
        <h1>お目当ての人はいますか？</h1>
        <p>
        <%= loginUser.getName() %>さん、ログイン中
            <a href="/SoftM/Logout">ログアウト</a>
        </p>
        <p><a href="/SoftM/Woman">更新</a></p>
        <form action="/SoftM/Woman" method="post">
        </form>
        
        
        <% for(MutterW mutterW : mutterListW) { %>
        <p><%= mutterW.getWUserName() %>:<%= mutterW.getWAge() %>:<%= mutterW.getWIncome() %></p>
        <% } %>
        
    </body>
</html>
