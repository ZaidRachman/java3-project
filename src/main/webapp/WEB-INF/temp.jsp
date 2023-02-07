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

    String tempInput = results.containsKey("tempInput") ? results.get("tempInput") : "";
    String temp = results.containsKey("temp") ? results.get("temp") : "";
    String unitTemp = results.containsKey("unitTemp") ? results.get("unitTemp") : "";

    String invalidTempError = results.containsKey("invalidTempError") ?  results.get("invalidTempError") : "";
    String unitTempError = results.containsKey("unitTempError") ?  results.get("unitTempError") : "";


%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Temperature Converter</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/temp.css">
</head>
<body>
<form action="temp" method="post">
    <div class="row">
        <h1>Temperature Converter</h1>
    </div>
    <div class="row">
        <p>Input a number and choose how you want to convert it!</p>
    </div>
    <div class="row">
        <div class="col-12">
            <input type="text" id="tempInput" name="tempInput" value="<%= tempInput %>"/>
            <label for="tempInput">Add temperature</label>
        </div>
        <div>
            <p><%=invalidTempError%></p>
        </div>
    </div>
    <div class="row">
        <div class="col-6">
            <input name="unitTemp" type="radio" value="fahrenheit" id="fahrenheit">
            <label>Fahrenheit to Celsius</label>
        </div>
        <div class="col-6">
            <input name="unitTemp" type="radio" value="celsius" id="celsius">
            <label name="celsius">Celsius to Fahrenheit</label>
        </div>
        <div>
            <p><%=unitTempError%></p>
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
