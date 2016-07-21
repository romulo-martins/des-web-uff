<%-- 
    Document   : lista-ingressos
    Created on : 17/07/2016, 05:30:10
    Author     : Romulo
--%>

<%@page import="model.Ingresso"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Ingressos</title>
    </head>
    <body>
        <div class="container">
            <h1>Ingressos</h1>
            <%
                List<Ingresso> ingressos = (List<Ingresso>) request.getAttribute("ingressos");
            %>
            <table class="table">
                <thead>
                    <tr>
                        <th>Evento</th>
                        <th>Tipo do ingresso</th>
                        <th>Valor do ingresso</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Ingresso ingresso : ingressos) { %>
                    <tr>
                        <td><%= ingresso.getEvento().getNome() %></td>
                        <td><%= ingresso.getTipo() %></td>
                        <td>R$ <%= ingresso.getValorPago() %></td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
                <hr />
            <a href="visualizarHistorico">Voltar</a> 
        </div>
    </body>
</html>
