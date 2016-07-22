<%-- 
    Document   : detalhes-evento
    Created on : 15/07/2016, 11:19:39
    Author     : Romulo
--%>

<%@page import="model.Carrinho"%>
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
    <body>
        <div class="container">
            <%
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                Evento evento = (Evento) request.getAttribute("evento");
                IngressoFactory factory = (IngressoFactory) request.getAttribute("ingresso_factory");
                Carrinho carrinho = (Carrinho) session.getAttribute("carrinho");
            %>
            <h1>Detalhes Evento</h1>

            <% if (usuario != null) {%>
            <p><a href="listar-carrinho.jsp">Meu Carrinho(<%= carrinho.getIngressos().size()%>)</a></p>            
            <% }%>

            <% if (request.getAttribute("qtdErro") != null) {%>
            <div class="alert alert-danger" role="alert">
                Ingressos acima do limite, <%=request.getAttribute("qtdErro")%>
                ingressos não puderam ser adicionados.
            </div>
            <% }%>

            <img src="img/<%= evento.getImagem()%>" width="320" height="240"><br />
            Nome: <%= evento.getNome()%><br />
            Descricao: <%= evento.getDescricao()%><br />
            Data: <%= evento.getData()%><br />
            Hora: <%= evento.getHora()%><br />
            Local: <%= evento.getLocal()%><br />

            Valor: <%= factory.getValorIngresso()%> <br />
            Ingressos disponiveis: <%= factory.getQuantidadeIngresso()%> 
            <% if (usuario != null) {%>
            <form action="mvc" method="get">
                <input type="hidden" name="logica" value="AdicionaCarrinhoLogic" >
                <input type="hidden" name="id" value="<%= evento.getId()%>">
                Qtd:
                <select name="qtd">
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                </select>
                <input type="radio" name="TipoEntrada" value="0" checked>Meia
                <input type="radio" name="TipoEntrada" value="1">Inteira

                <input type="submit" value="Adiciona Carrinho">
            </form>
            <% }%>
            <hr />
            <a href="mvc?logica=ListaEventosLogic">Voltar</a>
        </div>
    </body>
</html>
