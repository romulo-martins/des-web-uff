<%-- 
    Document   : detalhes-cliente
    Created on : 15/07/2016, 01:37:28
    Author     : Romulo
--%>

<%@page import="model.Cliente"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Detalhes Cliente</title>
    </head>
    <body>
        <div class="container">
            <% 
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Cliente cliente = usuario.getCliente();
            %>
            <h1>Detalhes</h1>
            <a href="editar-cliente.jsp">Editar</a> |
            <a href="visualizarHistorico">Historico de compras</a>
            <hr/>
            Nome: <%= cliente.getNome() %><br />
            Email: <%= cliente.getEmail() %><br />
            Telefone: <%= cliente.getTelefone() %><br />
            Data de nascimento: <%= cliente.getDataDeNascimento() %><br />      
            <hr />        
            <a href="bem-vindo.jsp">Pagina princial</a>
        </div>
    </body>
</html>
