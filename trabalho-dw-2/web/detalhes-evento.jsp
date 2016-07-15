<%-- 
    Document   : detalhes-evento
    Created on : 15/07/2016, 11:19:39
    Author     : Romulo
--%>

<%@page import="model.Evento"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalhes Evento</title>
    </head>
    <body>
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            Evento evento = (Evento) request.getAttribute("evento");
        %>
        <h1>Detalhes Evento</h1>
        Nome: <%= evento.getNome()%><br />
        Descricao: <%= evento.getDescricao()%><br />
        Data: <%= evento.getData()%><br />
        Hora: <%= evento.getHora()%><br />
        Local: <%= evento.getLocal()%><br />
        
        Valor: TODO <br />
        Ingressos disponiveis: TODO 
        <hr />
        <a href="mvc?logica=ListaEventosLogic">Voltar</a> |
        <% if (usuario != null) { %>
            <a href="">Adicionar ao carrinho</a>
        <% }%>
    </body>
</html>
