/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.EventoDao;
import model.Endereco;
import model.Evento;

/**
 *
 * @author Romulo
 */


public class AdicionaEvento {

    public static void main(String[] args) {
        Evento evento = new Evento();
        evento.setNome("Angra");
        evento.setHora("17:45");
        evento.setData("18/07/2016");
        evento.setLocal(new Endereco());
        //evento.criarIngresso(10, 7);
        
        EventoDao dao = new EventoDao();
        dao.adiciona(evento);
    }
}
