<%-- 
    Document   : adiciona-evento
    Created on : 13/07/2016, 22:02:32
    Author     : Romulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/bootstrap.css" >
        <title>Adiciona Evento</title>
    </head>
    <body>
        <h1>Adicionar Evento</h1>
        <hr />
        <form action="mvc">
            <input type="hidden" name="logica" value="AdicionaEventoLogic"/>
            Nome: <input type="text" name="nome" /><br />
            Descricao: <input type="text" name="descricao" /><br />
            Data: <input type="text" name="data" /><br />
            hora: <input type="text" name="hora" /><br />
            Local: <input type="text" name="local" /><br />
            <input type="submit" value="Salvar" />
        </form>

        <a href="mvc?logica=ListaEventosLogic">listar eventos</a>
    </body>
</html>
