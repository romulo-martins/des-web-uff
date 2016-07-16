/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import dao.EventoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Evento;

/**
 *
 * @author cafer
 */
@WebServlet(name = "AdicionarCarrinho", urlPatterns = {"/AdicionarCarrinho"})
public class AdicionarCarrinho extends HttpServlet {

  
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
        EventoDao dao = new EventoDao();
        List<Evento> eventos = dao.getLista();
        req.setAttribute("eventos", eventos);

        req.getRequestDispatcher("/adicionar-carrinho.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Integer userRequest = (Integer) sessao.getAttribute("userRequest");
        if (userRequest == null) {
            sessao.setAttribute("userRequest", (userRequest = 0));
        } else {
            sessao.setAttribute("userRequest", ++userRequest);
        }
        request.setAttribute("Acesso", userRequest);
    }
}
