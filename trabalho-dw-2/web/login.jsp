<%-- 
    Document   : login
    Created on : 03/07/2016, 16:16:44
    Author     : Romulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="validaUsuario" method="post">
            Name: <input type="text" name="name"/> <br />
            Password: <input type="password" name="password"/> <br />
            <input type="submit" value="LogIn"/>
        </form>
    </body>
</html>
