/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import modelo.Evento;

/**
 *
 * @author Romulo
 */

public class GerenciarEventos {

    private List<Evento> eventos;

    public GerenciarEventos() {
        this.eventos = new ArrayList<>();
    }

    public void seedEventos(List<Evento> eventos) {
        this.eventos.addAll(eventos);
    }
    
}
