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
                    <td><%= evento.getTipoEvento()%></td>
                    <td><%= evento.getData()%></td>
                    <td><%= evento.getHora()%></td>
                    <td><%= evento.getLocal()%></td>
                    <td>
                    <td>
                        <form action="mvc" method="get">
                            <input type="hidden" name="logica" value="AdicionaCarrinhoLogic" >
                            <input type="hidden" name="id" value="<%= evento.getId()%>">
                            <input type="radio" name="TipoEntrada" value="1" checked>Meia
                            <input type="radio" name="TipoEntrada" value="2">Inteira

                            <input type="submit" value="Adiciona Carrinho">
                            <a href="mvc?logica=AdicionaCarrinhoLogic&id=<%= evento.getId()%>">Adiciona Carrinho</a>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>
</html>
