/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Carrinho;
import model.Ticket;

/**
 *
 * @author cafer
 */
public class RemoverCarrinhoLogic implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Carrinho c = (Carrinho) req.getSession().getAttribute("carrinho");
        
        c.removerTicket(Integer.parseInt(req.getParameter("id")));
        
        return "listar-carrinho.jsp";

    }
    
}
