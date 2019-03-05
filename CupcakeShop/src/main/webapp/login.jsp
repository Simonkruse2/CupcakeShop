<%-- 
    Document   : shop
    Created on : Mar 5, 2019, 12:10:19 PM
    Author     : vince
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<a href="login.jsp"></a>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Controller?origin=checkLogin" method="post">
            <h1>Login page!</h1>
            Username: <input type="text" name="username" value=""><br>
            Password: <input type="text" name="password" value=""><br>
            <input type="submit" value="Click to login">
            </body>
        </form>
</html>
