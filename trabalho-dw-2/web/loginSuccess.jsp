<%-- 
    Document   : loginSuccess
    Created on : 03/07/2016, 16:21:08
    Author     : Romulo
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Logado com sucesso</title>
    </head>
    <body>
        <div class="container">
            <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
            <h1>Voce está logado <%= usuario.getCliente().getNome() %></h1>

            <a href="bem-vindo.jsp">Pagina principal</a>
        </div>
    </body>
</html>
