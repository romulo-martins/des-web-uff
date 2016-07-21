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
        <a href="forma-pagamento.jsp">Comprar</a>
    </form>
</body>
</html>
