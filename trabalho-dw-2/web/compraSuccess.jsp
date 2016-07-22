<%-- 
    Document   : newjsp
    Created on : 21/07/2016, 20:47:05
    Author     : cafer
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
            <p> <%= usuario.getCliente().getNome() %></p>
            <h1>Compra realizado com Sucesso!</h1>
            <a href="bem-vindo.jsp">Pagina principal</a>
        </div>
    </body>
</html>
