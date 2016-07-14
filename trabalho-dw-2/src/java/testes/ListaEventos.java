/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.EventoDao;
import java.util.List;
import model.Evento;

/**
 *
 * @author Romulo
 */

public class ListaEventos {
    
    public static void main(String[] args) {
        
        EventoDao dao = new EventoDao();
        List<Evento> eventos = dao.getLista();
        for(Evento evento : eventos) {
            System.out.println(evento);
        }
        
    }
    
}
