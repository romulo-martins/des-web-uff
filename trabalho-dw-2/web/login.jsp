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
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <h1>Login</h1>
            <form action="validaUsuario" method="post">
                <p>Name: <input type="text" name="name"/></p>
                <p>Password: <input type="password" name="password"/></p>            
                <input type="submit" value="Login"/>
            </form>

            <hr />
            <a href="bem-vindo.jsp">Pagina princial</a>            
        </div>
    </body>
</html>
