<%-- 
    Document   : forma-pagamento
    Created on : 21/07/2016, 11:12:13
    Author     : cafer
--%>

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
                Carrinho c = (Carrinho) request.getSession().getAttribute("carrinho");
                int total = 0;
                for (Ingresso ingresso : c.getIngressos()) {
                    total += ingresso.getValorPago();
                }
            %>
            <p>Valor total: R$ <%= total%></p>
            <form action="mvc" method="post">
                <input type="hidden" name="logica" value="PagamentoLogic" >
                Numero cartão:<br>
                <input type="text" name="ncartao"><br>
                Codigo segurança:<br>
                <input type="text" name="nseguranca">

                <input type="submit" value="Finalizar Comprar">
            </form>            
        </div>
    </body>
</html>
