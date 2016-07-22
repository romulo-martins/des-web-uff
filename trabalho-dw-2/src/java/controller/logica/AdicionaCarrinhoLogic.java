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
import model.IngressoFactory;
import tipos.TipoIngresso;

/**
 *
 * @author cafer
 */
public class AdicionaCarrinhoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        
        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");
        
        Evento evento = new EventoDao(connection).busca(Integer.parseInt(req.getParameter("id")));

        int qtd = 0;
        for (Ingresso i : c.getIngressos()) {
            if (i.getEvento().getId() == evento.getId()) {
                qtd++;
            }
        }

        IngressoFactoryDao factory = new IngressoFactoryDao();
        IngressoFactory iFactory = factory.getFactory(evento);
        if (iFactory.getQuantidadeIngresso() > 0) {
            for (int i = 0; i < Integer.parseInt(req.getParameter("qtd")) - qtd; i++) {
                Ingresso ingresso = iFactory.gerarIngresso(TipoIngresso.getTipo(Integer.parseInt(req.getParameter("TipoEntrada"))));
                c.adicionar(ingresso);
                //factory.updateEstoque(evento, "REMOVER");
            }
        }
        if (Integer.parseInt(req.getParameter("qtd")) + qtd > 4) {
            int qtdErro = 4 - Math.abs((Integer.parseInt(req.getParameter("qtd")) - qtd));
            req.setAttribute("qtdErro", qtdErro);
        }
        return "/detalhesEvento?id=" + req.getParameter("id");
    }

}
