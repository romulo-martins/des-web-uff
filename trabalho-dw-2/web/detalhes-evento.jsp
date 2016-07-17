<%-- 
    Document   : detalhes-evento
    Created on : 15/07/2016, 11:19:39
    Author     : Romulo
--%>

<%@page import="model.IngressoFactory"%>
<%@page import="model.Evento"%>
<%@page import="model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Detalhes Evento</title>
    </head>
    <body
        <div class="container">
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Evento evento = (Evento) request.getAttribute("evento");
                IngressoFactory factory = (IngressoFactory) request.getAttribute("ingresso_factory");
            %>
            <h1>Detalhes Evento</h1>
            <img src="img/<%= evento.getImagem() %>" width="320" height="240"><br />
            Nome: <%= evento.getNome()%><br />
            Descricao: <%= evento.getDescricao()%><br />
            Data: <%= evento.getData()%><br />
            Hora: <%= evento.getHora()%><br />
            Local: <%= evento.getLocal()%><br />

            Valor: <%= factory.getValorIngresso() %> <br />
            Ingressos disponiveis: <%= factory.getQuantidadeIngresso() %> 
            <hr />
            <a href="mvc?logica=ListaEventosLogic">Voltar</a>
            <% if (usuario != null) { %>
                | <a href="">Adicionar ao carrinho</a>
            <% }%>
        </div>
    </body>
</html>
