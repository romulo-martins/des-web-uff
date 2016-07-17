<%-- 
    Document   : bemvindo
    Created on : 13/07/2016, 20:25:22
    Author     : Romulo
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Bem vindo</title>
    </head>
    <body>
        <div class="container">
            <% Usuario usuario = (Usuario) session.getAttribute("usuario");%>
            <h1>Loja virtual de ingressos</h1>
            <hr />
            <% if (usuario != null) {%>
            <p>Bem vindo <em><%= usuario.getCliente().getNome()%></em>!</p>    
            <% } %>

            <a href="mvc?logica=ListaEventosLogic">Visualizar eventos</a> | 
            <% if (usuario != null) { %>
            <a href="detalhes-cliente.jsp">Meus dados</a> |
            <a href="logout">Sair</a>
            <% } else { %>
            <a href="login.jsp">Realizar Login</a>
            <% }%>            
        </div>
    </body>
</html>
