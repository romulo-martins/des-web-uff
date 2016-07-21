/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller.servlet;

import dao.IngressoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Ingresso;

/**
 *
 * @author Romulo
 */
@WebServlet("/visualizarIngressos")
public class VisualizarIngressos extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int codCompra = Integer.parseInt(req.getParameter("cod"));

        List<Ingresso> ingressos = new IngressoDao().getIngressos(codCompra);
        req.setAttribute("ingressos", ingressos);

        RequestDispatcher rd = req.getRequestDispatcher("/lista-ingressos.jsp");
        rd.forward(req, resp);
    }

}
