<%-- 
    Document   : teste
    Created on : 15/07/2016, 12:44:58
    Author     : cafer
--%>

<%@page import="java.util.List"%>
<%@page import="model.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h2><%= request.getAttribute("Acesso")%></h2>
        <table>
            <thead>
            <tbody>
                <%
                    List<Evento> eventos = (List) request.getAttribute("eventos");
                    for (Evento evento : eventos) {
                %>
                <tr>
                    <td><%= evento.getNome()%></td>
                    <td><%= evento.getDescricao()%></td>
                    <td><%= evento.getTipo()%></td>
                    <td><%= evento.getData()%></td>
                    <td><%= evento.getHora()%></td>
                    <td><%= evento.getLocal()%></td>
                    <td>
                    <td>
                        <a href="mvc?logica=AdicionaCarrinhoLogic&id=<%= evento.getId()%>">Adiciona Carrinho</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
