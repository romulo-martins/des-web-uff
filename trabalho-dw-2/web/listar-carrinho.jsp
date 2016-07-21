<%-- 
    Document   : listar-carrinho
    Created on : 15/07/2016, 19:53:02
    Author     : cafer
--%>

<%@page import="model.Ticket"%>
<%@page import="model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Meu Carrinho</p>
        <table>
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
                    for (Ticket ticket : c.getEntrada()) {
                %>
                <tr>
                    <td><%= ticket.getNome()%></td>
                    <td><%= ticket.getPreco()%></td>
                    <td><%= ticket.getTipoTicket().name()%></td>
                    <td>
                        <a href="mvc?logica=RemoverCarrinhoLogic&id=<%= ticket.getId()%>">Remover</a>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a href="forma-pagamento.jsp">Comprar</a>
    </form>
</body>
</html>
