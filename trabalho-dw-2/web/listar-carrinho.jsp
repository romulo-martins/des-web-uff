<%-- 
    Document   : listar-carrinho
    Created on : 15/07/2016, 19:53:02
    Author     : cafer
--%>

<%@page import="model.Ingresso"%>
<%@page import="model.Ticket"%>
<%@page import="model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">            
            <h2>Meu Carrinho</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Preço</th>
                        <th>Tipo Ingresso</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Carrinho c = (Carrinho) request.getSession().getAttribute("carrinho");
                        for (Ingresso ingresso : c.getIngressos()) {
                    %>
                    <tr>
                        <td><%= ingresso.getEvento().getNome()%></td>
                        <td><%= ingresso.getValorPago()%></td>
                        <td><%= ingresso.getTipo()%></td>
                        <td>
                            <a href="mvc?logica=RemoverCarrinhoLogic&id=<%= ingresso.getId()%>">Remover</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="mvc?logica=ListaEventosLogic">Listar eventos</a> |     
            <a href="forma-pagamento.jsp">Comprar</a>
        </div>
    </body>
</html>
