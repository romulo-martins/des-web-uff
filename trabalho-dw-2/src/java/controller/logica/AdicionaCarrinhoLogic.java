/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Evento;
import tipos.TipoIngresso;

/**
 *
 * @author cafer
 */
public class AdicionaCarrinhoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho carrinho = new Carrinho();
        HttpSession session = req.getSession();
        session.setAttribute("carrinho", carrinho);

        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        EventoDao dao = new EventoDao();
        Evento evento = dao.busca(Integer.parseInt(req.getParameter("id")));

        TipoIngresso tipo = TipoIngresso.Inteira;
        if (req.getParameter("TipoEntrada").equals("1")) {
            tipo = TipoIngresso.Meia;
        }


        for (int i = 0; i < Integer.parseInt(req.getParameter("qtd")); i++) {
            //Ticket entrada = new Ticket(evento.getIngresso(), tipo);
            //c.adicionarTicket(entrada);
        }
        return "/AdicionarCarrinho";
    }
}
