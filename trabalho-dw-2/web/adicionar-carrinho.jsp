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
                            Qtd:
                            <select name="qtd">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                            <input type="radio" name="TipoEntrada" value="1" checked>Meia
                            <input type="radio" name="TipoEntrada" value="2">Inteira

                            <input type="submit" value="Adiciona Carrinho">
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
           <a href="listar-carrinho.jsp">Meu Carrinho</a>
    </body>
</html>
