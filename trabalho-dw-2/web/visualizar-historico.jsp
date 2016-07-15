<%-- 
    Document   : visualizar-historico
    Created on : 15/07/2016, 20:35:32
    Author     : Romulo
--%>

<%@page import="model.Historico"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Historico de compras</title>
    </head>
    <body>
        <h1>Historico de compras</h1>
        <%
            List<Historico> historico = (List<Historico>) request.getAttribute("historico");

        %>
        <table>
            <thead>
                <tr>
                    <th>Data</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                <%                    for (Historico linhaHistorico : historico) {
                %>
                <tr>
                    <td><%= linhaHistorico.getDataCompra()%></td>
                    <td><%= linhaHistorico.getValorCompra()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <hr />
        <a href="detalhes-cliente.jsp">Voltar</a>
    </body>
</html>
