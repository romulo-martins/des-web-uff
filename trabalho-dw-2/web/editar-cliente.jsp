<%-- 
    Document   : editar-cliente
    Created on : 15/07/2016, 02:03:51
    Author     : Romulo
--%>

<%@page import="model.Cliente"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Cliente</title>
    </head>
    <body>
        <h1>Editar Cliente</h1>
        <hr />
        <%
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            Cliente cliente = usuario.getCliente();
        %>
        <form action="editaCliente">
            <input type="hidden" name="id" value="<%= cliente.getId() %>"/>
            Nome: <input type="text" name="nome" value="<%= cliente.getNome()%>" /><br />
            E-mail: <input type="text" name="email" value="<%= cliente.getEmail()%>" /><br />
            Telefone: <input type="text" name="telefone" value="<%= cliente.getTelefone()%>" /><br />
            Data Nascimento: <input type="text" name="data_nascimento" value="<%= cliente.getDataDeNascimento()%>" /><br />
            <input type="submit" value="Salvar" />
        </form>
        <hr />
        <a href="detalhes-cliente.jsp">Voltar</a>
    </body>
</html>
