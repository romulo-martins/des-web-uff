<%-- 
    Document   : forma-pagamento
    Created on : 21/07/2016, 11:12:13
    Author     : cafer
--%>

<%@page import="model.Usuario"%>
<%@page import="model.Ingresso"%>
<%@page import="model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Forma de pagamento</title>
    </head>
    <body>
        <div class="container">
            <h1>Forma de Pagamento</h1>
            <!-- Buscar cliente na session e apresentar o nome-->
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Carrinho c = (Carrinho) request.getSession().getAttribute("carrinho");
                String msgObg = (String) request.getAttribute("msgObg");
                int total = 0;
                for (Ingresso ingresso : c.getIngressos()) {
                    total += ingresso.getValorPago();
                }
            %>
            <p>Valor total: R$ <%= total%></p>

            <% if (msgObg != null) {%>
            <div class="alert-danger" role="alert"><%= msgObg%></div>
            <% }%>
            <form action="mvc" method="post">
                <input type="hidden" name="logica" value="PagamentoLogic" >
                Nome: <br>
                <input disabled type="text" name="nome" value=<%= usuario.getCliente().getNome() %> > <br>
                Data de Nascimento: <br>
                <input disabled type="date" name="dt" value=<%= usuario.getCliente().getDataDeNascimento() %> > <br>
                Email: <br>
                <input disabled type="text" name="email" value=<%= usuario.getCliente().getEmail() %> > <br>
                Telefone: <br>
                <input disabled type="tel" name="email" value=<%= usuario.getCliente().getTelefone() %> > <br>
                *Numero cartão:<br>
                <input type="number" name="ncartao"><br>
                *Codigo segurança:<br>
                <input type="number" name="nseguranca">
                
                <p>* Campos obrigatórios</p>
                <input type="submit" value="Finalizar Comprar">
            </form>    
            <hr />
            <a href="listar-carrinho.jsp">Voltar</a>
        </div>
    </body>
</html>
