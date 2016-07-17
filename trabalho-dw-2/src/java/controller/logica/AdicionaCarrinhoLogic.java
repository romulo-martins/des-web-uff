/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Evento;
import model.Ingresso;
import tipos.TipoIngresso;

/**
 *
 * @author cafer
 */

public class AdicionaCarrinhoLogic implements Logica{


    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho carrinho = new Carrinho();
        HttpSession session = req.getSession();
        session.setAttribute("carrinho", carrinho);
        Evento evento = new Evento();
        
        Ingresso ingresso = new Ingresso(1, 100, TipoIngresso.Meia, evento);
        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        c.adicionar(ingresso);
        return "/TestServlet";

    }

}
