/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.servlet;

import dao.HistoricoDao;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Historico;
import model.Usuario;

/**
 *
 * @author Romulo
 */
@WebServlet("/visualizarHistorico")
public class VisualizarHistorico extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // altera a sessao para os dados novos do usuário
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        
        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        // salva as alteraçõs do cliente
        HistoricoDao dao = new HistoricoDao(connection);
        List<Historico> historico = dao.busca(usuario.getCliente().getId());
        
        req.setAttribute("historico", historico);

        RequestDispatcher rd = req.getRequestDispatcher("/visualizar-historico.jsp");
        rd.forward(req, resp);
    }

}
