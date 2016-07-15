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
import model.Ticket;
import model.Evento;
import tipos.TipoIngresso;

/**
 *
 * @author cafer
 */
//@WebServlet("/adicionaCarrinho")
public class AdicionaCarrinhoLogic implements Logica{ //extends HttpServlet {


    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho carrinho = new Carrinho();
        HttpSession session = req.getSession();
        session.setAttribute("carrinho", carrinho);
        EventoDao dao = new EventoDao();
        Evento evento = dao.busca(Integer.parseInt(req.getParameter("id")));
        
        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        
        TipoIngresso tipo = TipoIngresso.Inteira;
        if(req.getParameter("TipoEntrada").equals("1")){
            tipo = TipoIngresso.Meia;
        }
        Ticket entrada = new Ticket(evento.getIngresso(), tipo);
        c.AdicionarCarrinho(entrada);
        return "/TestServlet";

    }
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Carrinho carrinho = new Carrinho();
//        HttpSession session = req.getSession();
//        session.setAttribute("carrinho", carrinho);
//
//        int id = Integer.parseInt(req.getParameter("id"));
//
//        Evento evento = new Evento();
//        Ingresso ingresso = new Ingresso(1, 100, TipoIngresso.Meia, evento);
//        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
//        c.AdicionarCarrinho(ingresso);
//
//        RequestDispatcher rd = req.getRequestDispatcher("/teste.jsp");
//        rd.forward(req, resp);
//    }
}
