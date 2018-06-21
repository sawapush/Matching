<%-- 
    Document   : man
    Created on : 2017/12/25, 14:59:21
    Author     : g16934os
--%>

<%@page import="java.util.List"%>
<%@page import="model.MutterM"%>
<%@page import="model.User"%>
<%@page  language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% // セッションスコープに保存されたユーザー情報を取得 
    User loginUser = (User) session.getAttribute("loginUser");
    List<MutterM>mutterListM = (List<MutterM>) request.getAttribute("mutterList");
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
        <p><a href="/SoftM/Man">更新</a></p>
        <form action="/SoftM/Man" method="post">
        </form>
        
        
        <% for(MutterM mutterM : mutterListM) { %>
        <p><%= mutterM.getMUserName() %>:<%= mutterM.getMAge() %>:<%= mutterM.getMIncome() %></p>
        <% } %>
        
    </body>
</html>