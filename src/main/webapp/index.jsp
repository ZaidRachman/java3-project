<%@ page import="com.rachman.ch5.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    User user = (User)session.getAttribute("user");

%>
<!DOCTYPE html>
<html>
<head>
    <title>Table of Contents</title>
</head>
<body>
<h1><%= "Hello Zaid!" %></h1>
<h3>Chapter 3 and 4</h3>
<ul>
    <li><a href="add">Adding App</a></li>
    <li><a href="temp">Temperature Converter</a> </li>
    <li><a href="bmi">BMI Calculator</a> </li>
    <li><a href="send-message">Send a Text Message</a></li>


</ul>
<h3>Chapters 5</h3>
<ul>
    <% if(user != null && user.getPrivileges().equals("admin")){ %>
    <li><a href="view-users">View All Users</a></li>
    <% } %>

    <% if(user == null) { %>
    <li><a href="signup">Add User</a></li>
    <li><a href="login">Login</a></li>
    <% } else { %>
    <li><a href="profile">View Profile</a></li>
    <li><a href="logout">Logout</a></li>
    <% } %>
</ul>
<h3>Fun Stuff</h3>
    <li><a href="countries">Countries</a></li>
    <li><a href="artist">Spotify App</a></li>
    <li><a href="chat">Chat App</a></li>
    <li><a href="tictactoe">Tic-Tac-Toe</a></li>
<h3> Final </h3>
    <li><a href="newsLetter">NewsLetter</a> </li>
<%--<a href="hello-servlet">Hello Servlet</a>--%>
</body>
</html>