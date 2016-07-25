<%-- 
    Document   : newjsp
    Created on : 21/07/2016, 20:47:05
    Author     : cafer
--%>

<%@page import="model.Carrinho"%>
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
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            %>
            <% if (usuario != null) {%>
            <p>
                <a href="listar-carrinho.jsp">Meu Carrinho(<%= carrinho.getIngressos().size()%>)</a>
            </p>            
            <% }%>
            <h1>Compra finalizada.</h1>
            <%
                String msgSucesso = (String) request.getAttribute("msgSuccess");
                String msgErro = (String) request.getAttribute("msgErro");
                String msgCarrinho = (String) request.getAttribute("msgCarrinho");
            %>
            <% if (msgSucesso != null) {%>
            <div class="alert-success" role="alert"><%= msgSucesso%></div>
            <% }%>

            <% if (msgErro != null) {%>
            <div class="alert-danger" role="alert"><%= msgErro%></div>
            <% }%>

            <% if (msgCarrinho != null) {%>
            <div class="alert-danger" role="alert"><%= msgCarrinho%></div>
            <% }%>

            <p>Para imprimir seus ingressos, visualize seu histórico!</p>
            <hr />
            <a href="bem-vindo.jsp">Pagina principal</a> |
            <a href="visualizarHistorico">Historico</a>
        </div>
    </body>
</head>
</html>
