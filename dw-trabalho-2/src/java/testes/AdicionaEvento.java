/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.EventoDao;
import model.Evento;
import tipos.TipoEvento;

/**
 *
 * @author Romulo
 */
public class AdicionaEvento {

    public static void main(String[] args) {
        Evento evento = new Evento();
        evento.setNome("Vingadores");
        evento.setTipo(TipoEvento.Cinema);
        evento.setHora("16:30");
        evento.setData("7/07/2016");
        evento.setLocal("Cinemark Plaza");
        
        EventoDao dao = new EventoDao();
        dao.adiciona(evento);
    }
}
