<%-- 
    Document   : response
    Created on : May 14, 2018, 11:21:37 AM
    Author     : diana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="mybean" scope="session" class="frontend.FrontEnd" />
        <jsp:setProperty name="mybean" property="city" />
        <h1>Hello, <jsp:getProperty name="mybean" property="city" />!</h1>
        
    </body>
</html>
