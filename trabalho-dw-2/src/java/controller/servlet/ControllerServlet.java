/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import controller.logica.Logica;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Romulo
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parametro = req.getParameter("logica");
        String nomeDaClasse = "controller.logica." + parametro;

        try {
            Class classe = Class.forName(nomeDaClasse);

            Logica logica = (Logica) classe.newInstance();
            String pagina = logica.executa(req, resp);

            req.getRequestDispatcher(pagina).forward(req, resp);
        } catch (Exception e) {
            throw new ServletException("A lógica de negócios causou uma exceção", e);
        }

    }
}
