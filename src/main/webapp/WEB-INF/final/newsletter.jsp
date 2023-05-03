<%@ page import="java.util.Set" %>
<%@ page import="java.util.HashSet" %>
<%@ page import="com.rachman.ch5.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- STEP 14: Write a scriptlet to get the Set of subscribers from the request object --%>
<%

    Set subscriber = (Set)request.getAttribute("subscribers");
    if(subscriber == null){
        subscriber = new HashSet<>();
    }

    String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Newsletter Signup</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

<div class="container my-5">
    <h2 class="text-center mb-4">Newsletter Signup</h2>
    <div class="row justify-content-center">
        <div class="col-lg-6 col-md-8 col-sm-10">
            <%-- STEP 15: Write an if statement that tests if the Set of subscribers has no elements --%>
            <% if ( subscriber.size() == 0) { %>
                <form action="newsLetter" method="post"><%-- STEP 2: Add an action and method attribute --%>
                    <div class="form-group">
                        <label for="email">Email address:</label>
                        <input type="text" class="form-control" id="email" placeholder="Enter email" name="email" value=${email}><%-- STEP 4: Add a name and value attribute --%>
                    </div>
                    <button type="submit" class="btn btn-primary">Subscribe</button>
                </form>
                <div class="my-4">
                    <% if(message != null){ %>
                    <%=message%>
                    <% }%>
                </div><%-- STEP 9: Display the message from the servlet using Java Expression Language --%>
            <% } else { %>

            <%-- STEP 16: Write an else statement that starts here and stops after the unordered list --%>
            <h3>All Subscribers</h3>
            <ul>
                <%-- STEP 17: Write a for-each loop to print all of the subscriber's email addresses --%>
                <% for (Object user : subscriber) {%>
                <li><%= user%></li>
                <% } %>
            </ul>
            <% } %>

        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

</body>
</html>
