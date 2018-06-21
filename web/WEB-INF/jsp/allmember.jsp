<%--
    Document   : allmember
    Created on : 2018/06/18, 17:03:49
    Author     : g16934os
--%>
<%@page import="model.MutterW"%>
<%@page import="java.util.List"%>
<%@page import="model.MutterM"%>
<%@page import="model.User"%>
<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% // セッションスコープに保存されたユーザー情報を取得 
    User loginUser = (User) session.getAttribute("loginUser");
    List<MutterM>mutterListM = (List<MutterM>) request.getAttribute("mutterList");
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
        <h1>登録者一覧</h1>
        <p>
        <%= loginUser.getName() %>さん、ログイン中
            <a href="/SoftM/Logout">ログアウト</a>
        </p>
        <p><a href="/SoftM/Man">更新</a></p>
        <form action="/SoftM/Man" method="post">
        </form>
        <% for(MutterM mutterM : mutterListM) { %>
        <p><%= mutterM.getMUserName() %>:<%= mutterM.getMAge() %>:<%= mutterM.getMIncome() %></p>
        <% } %>
        <% for(MutterW mutterW : mutterListW) { %>
        <p><%= mutterW.getWUserName() %>:<%= mutterW.getWAge() %>:<%= mutterW.getWIncome() %></p>
        <% } %>
        
    </body>
</html>