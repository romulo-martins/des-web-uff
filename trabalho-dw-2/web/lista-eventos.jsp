<%-- 
    Document   : lista-eventos
    Created on : 13/07/2016, 20:19:42
    Author     : Romulo
--%>

<%@page import="model.Carrinho"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="model.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Eventos</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Eventos</h1>
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            %>
            <% if (usuario != null) {%>
            <a href="listar-carrinho.jsp">
                <span class="glyphicon glyphicon-shopping-cart"></span>
                Meu Carrinho(<%= carrinho.getIngressos().size()%>)
            </a>
            <% }%>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descricao</th>
                        <th>Data</th>
                        <th>Hora</th>
                        <th></th>
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
                        <td>
                            <a href="detalhesEvento?id=<%= evento.getId()%>">Detalhes</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <hr />
            <a href="bem-vindo.jsp">Pagina principal</a>
        </div>
    </body>
</html>
