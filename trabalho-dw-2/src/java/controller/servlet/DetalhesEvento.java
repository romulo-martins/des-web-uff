/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import dao.EventoDao;
import dao.IngressoFactoryDao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;
import model.IngressoFactory;

/**
 *
 * @author Romulo
 */
@WebServlet("/detalhesEvento")
public class DetalhesEvento extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        int id = Integer.parseInt(req.getParameter("id"));

        // salva as alteraçõs do cliente
        Evento evento = new EventoDao(connection).busca(id);
        IngressoFactory factory = new IngressoFactoryDao().getFactory(evento);

        req.setAttribute("evento", evento);
        req.setAttribute("ingresso_factory", factory);

        RequestDispatcher rd = req.getRequestDispatcher("/detalhes-evento.jsp");
        rd.forward(req, resp);
    }

}
