/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import auxiliares.RequestToCliente;
import auxiliares.TipoCRUD;
import dao.ClienteDao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author Romulo
 */
@WebServlet("/editaCliente")
public class EditaCliente extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cliente = RequestToCliente.executa(req, resp, TipoCRUD.Altera);

        // altera a sessao para os dados novos do usuário
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        usuario.setCliente(cliente);

        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        // salva as alteraçõs do cliente
        ClienteDao dao = new ClienteDao(connection);
        dao.altera(cliente);

        RequestDispatcher rd = req.getRequestDispatcher("/detalhes-cliente.jsp");
        rd.forward(req, resp);
    }

}
