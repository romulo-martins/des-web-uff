<%-- 
    Document   : newjsp
    Created on : 21/07/2016, 20:47:05
    Author     : cafer
--%>

<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Status da Compra</title>
    </head>
    <body>
        <div class="container">
            <h1>Compra finalizada.</h1>
            <%
                String msgSucesso = (String) request.getAttribute("msgSuccess");
                String msgErro = (String) request.getAttribute("msgErro");
            %>
            <% if (msgSucesso != null) {%>
            <div class="alert-success" role="alert"><%= msgSucesso%></div>
            <% }%>

            <% if (msgSucesso != null) {%>
            <div class="alert-danger" role="alert"><%= msgErro%></div>
            <% }%>

            <p>Para imprimir seus ingressos, visualize seu histórico!</p>
            <hr />
            <a href="bem-vindo.jsp">Pagina principal</a> |
            <a href="visualizarHistorico">Historico</a>
        </div>
    </body>
</html>
