/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Usuario;

/**
 *
 * @author Romulo
 */
@WebServlet("/validaUsuario")
public class ValidaUsuario extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd;
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        Usuario usuario = validateLogin(name, password);
        Carrinho carrinho = new Carrinho();
        if (usuario == null) {
            rd = req.getRequestDispatcher("/loginError.jsp");
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("carrinho", carrinho);
            rd = req.getRequestDispatcher("/loginSuccess.jsp");
        }

        rd.forward(req, resp);
    }

    private Usuario validateLogin(String name, String password) {
        // Todos os parametros precisam ser válidos
        if (name == null || password == null) {
            return null;
        }
        UsuarioDao dao = new UsuarioDao();
        Usuario user = dao.getUsuario(name);

        if (user == null) {
            return null;
        }

        // Checa se a senha é válida
        if (!user.getPassword().equals(password.trim())) {
            return null;
        }

        return user;
    }

}
