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
        <title>Bem vindo</title>
    </head>
    <body>
        <% Usuario usuario = (Usuario) session.getAttribute("usuario"); %>
        <h1>Bem vindo ao Super Ingressos <em><%= usuario.getCliente().getNome() %></em>!</h1>
        <a href="mvc?logica=ListaEventosLogic">Visualizar eventos</a> | 
        <a href="detalhes-cliente.jsp">Meus dados</a>
    </body>
</html>
