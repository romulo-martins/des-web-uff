package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Romulo
 */

@WebServlet("/mathit")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int value1;
        int value2;
        int total = 0;
        
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        
        String warning = "";

        try {
            value1 = Integer.parseInt((String) req.getParameter("value1"));
            value2 = Integer.parseInt((String) req.getParameter("value2"));
        } catch (NumberFormatException e) {
            value1 = 0;
            value2 = 0;
            warning = "We got some bad value(blank or non numerics values, we set 0 instead";
        }

        req.setAttribute("name", user.getName());
        req.setAttribute("warning", warning);

        total = value1 + value2;

        req.setAttribute("total", total);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("show.jsp");

        requestDispatcher.forward(req, res);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
