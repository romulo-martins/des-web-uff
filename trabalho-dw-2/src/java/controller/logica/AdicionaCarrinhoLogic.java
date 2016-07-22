/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import dao.IngressoFactoryDao;
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
        Evento evento = new EventoDao().busca(Integer.parseInt(req.getParameter("id")));

        IngressoFactoryDao factory = new IngressoFactoryDao();
        IngressoFactory iFactory = factory.getFactory(evento);
        if (iFactory.getQuantidadeIngresso() > 0) {
            for (int i = 0; i < Integer.parseInt(req.getParameter("qtd")); i++) {
                Ingresso ingresso = iFactory.gerarIngresso(TipoIngresso.getTipo(Integer.parseInt(req.getParameter("TipoEntrada"))));
                c.adicionar(ingresso);
                factory.updateEstoque(evento, "REMOVER");
            }
        }
        return "/detalhesEvento?id=" + req.getParameter("id");
    }

}
