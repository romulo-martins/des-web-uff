/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import dao.EventoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;

/**
 *
 * @author Romulo
 */
@WebServlet("/detalhesEvento")
public class DetalhesEvento extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));

        // salva as alteraçõs do cliente
        EventoDao dao = new EventoDao();
        Evento evento = dao.busca(id);
        
        req.setAttribute("evento", evento);

        RequestDispatcher rd = req.getRequestDispatcher("/detalhes-evento.jsp");
        rd.forward(req, resp);
    }

}
