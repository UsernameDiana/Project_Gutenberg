<%-- 
    Document   : response
    Created on : May 14, 2018, 11:21:37 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="" %>
<!--import the class with the info-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="BookRest" method="POST" name="BookRestful">
            <input type="hidden" name="command" value="getBooksByCityName">
            <input type="text" name="city" value="" />
            <input type="submit" value="Submit" name="Submit" />
        </form>
    </body>
</html>
