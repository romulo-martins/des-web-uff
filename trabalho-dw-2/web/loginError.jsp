<%-- 
    Document   : loginError
    Created on : 03/07/2016, 16:20:25
    Author     : Romulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Error</title>
    </head>
    <body>
        <div class="container">
            <div class="alert alert-danger" role="alert">
                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                <span class="sr-only">Error:</span>
                Usuário ou senha Incorretas!
            </div>
            <a href="login.jsp">Logar</a> |
            <a href="bem-vindo.jsp">Pagina princial</a>            
        </div>
    </body>
</html>
