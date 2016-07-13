/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class ListaEventosLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        EventoDao dao = new EventoDao();
        
        List<Evento> eventos = dao.getLista();
        
        // passa a lista de contatos para requisição para que possa ser acessada pela view lista-contatos
        req.setAttribute("eventos", eventos);
        
        return "lista-eventos.jsp";
    }
    
}
