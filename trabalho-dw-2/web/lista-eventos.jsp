<%-- 
    Document   : lista-eventos
    Created on : 13/07/2016, 20:19:42
    Author     : Romulo
--%>

<%@page import="java.util.List"%>
<%@page import="model.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eventos</title>
    </head>
    <body>
        <h1>Lista de Eventos</h1>
        <a href="adiciona-evento.jsp">Adicionar Contato</a>
        <hr />
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descricao</th>
                    <th>Data</th>
                    <th>Hora</th>
                    <th>Local</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Evento> eventos = (List) request.getAttribute("eventos");
                    for (Evento evento : eventos) {
                %>
                <tr>
                    <td><%= evento.getNome()%></td>
                    <td><%= evento.getDescricao()%></td>
                    <td><%= evento.getData()%></td>
                    <td><%= evento.getHora()%></td>
                    <td><%= evento.getLocal()%></td>
                    <td>
                    <td>
                        <a href="mvc?logica=RemoveEventoLogic&id=<%= evento.getId()%>">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <hr />
        <a href="bem-vindo.jsp">Pagina principal</a>
    </body>
</html>
