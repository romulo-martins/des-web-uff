/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import dao.IngressoFactoryDao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Evento;
import model.Ingresso;

/**
 *
 * @author cafer
 */
public class RemoverCarrinhoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        Ingresso i = c.getIngresso(Integer.parseInt(req.getParameter("id")));

        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        if (i != null) {
            Evento evento = new EventoDao(connection).busca(i.getEvento().getId());
            IngressoFactoryDao f = new IngressoFactoryDao();
            c.remover(Integer.parseInt(req.getParameter("id")));
            // f.updateEstoque(evento, "ADICIONAR");
        }
        return "listar-carrinho.jsp";
    }

}
