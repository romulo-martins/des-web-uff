/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import auxiliares.RequestToEvento;
import auxiliares.TipoCRUD;
import dao.EventoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class AdicionaEventoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        Evento evento = RequestToEvento.executa(req, res, TipoCRUD.Adiciona);
        
        // salva o contato
        EventoDao dao = new EventoDao();
        dao.adiciona(evento);
        
        System.out.println("Cadastrando eventos...");

        return "mvc?logica=ListaEventosLogic";
    }
    
}
