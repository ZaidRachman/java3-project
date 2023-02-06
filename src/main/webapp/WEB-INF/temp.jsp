<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: rachm
  Date: 2/4/2023
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Map<String, String> results = (Map<String, String>)request.getAttribute("results");
    if (results == null){
        results = new HashMap<>();
    }

    String temp1 = results.containsKey("tempInput") ? results.get("tempInput") : "";
    String temp = results.containsKey("temp") ? results.get("temp") : "";

%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Temperature Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<form action="temp" method="post" >
    <div class="row">
        <div class="col-12">
            <h1>Temperature Converter</h1>

        </div>
    </div>
    <div class="row">
        <p>IMPORTANT INSTRUCTIONS!</p>

    </div>
    <div class="row">
        <div class="col-6">
            <input type="text" id="tempInput" name="tempInput" value="<%= temp1 %>"/>
            <label for="tempInput">Fahrenheit</label>
        </div>
        <div class="col-6">
            <p id="tempResult">Celsius</p>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <input name="UnitTemp" type="radio" value="fahrenheit" id="fahrenheit">
            <label>Fahrenheit</label>
        </div>
        <div class="col-6">
            <input name="UnitTemp" type="radio" value="celsius" id="celsius">
            <label name="celsius">Celsius</label>
        </div>
    </div>
    <div class="row">
        <% if(!temp.equals("")) { %>
        <p>Calculation: <%=temp%></p>

        <% } %>
        <input type="submit" value="Convert Temperature">
    </div>
</form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

</body>

</html>
