/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.EventoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class RemoveEventoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        Evento evento = new Evento();
        evento.setId(id);
        
        EventoDao dao = new EventoDao();
        dao.remove(evento);
        
        System.out.println("Excluindo contato...");
        
        return "mvc?logica=ListaEventosLogic";
    }
    
}
