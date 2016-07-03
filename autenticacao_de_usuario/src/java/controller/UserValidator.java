/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import model.User;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Romulo
 */
@WebServlet("/userValidator")
public class UserValidator extends HttpServlet {

    private UserDao users;
     
    /**
     * Creates valid users 
     * 
     * This User Map could be users returned from a database
     * or a simple select with the user.name
     * 
     * @return a Map of valid users
     */
    private static Map<String, User> getUsers() {
        Map<String, User> users = new HashMap<>();
         
        User userOne = new User("one","one");
        User userTwo = new User("two","TWO");
         
        users.put(userOne.getName(), userOne);
        users.put(userTwo.getName(), userTwo);
         
        return users;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd;
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        User user = validateLogin(name, password);

        if (user == null) {
            rd = req.getRequestDispatcher("/loginError.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            rd = req.getRequestDispatcher("/loginSuccess.jsp");
        }

        rd.forward(req, resp);
    }

    private User validateLogin(String name, String password) {
        // All parameters must be valid
        if (name == null || password == null) {
            return null;
        }
        this.users = new UserDao();
        // Get a user by key
        User user = users.getUser(name);

        if (user == null) {
            return null;
        }

        // Check if the password is valid
        if (!user.getPassword().equals(password.trim())) {
            return null;
        }

        return user;
    }

}
