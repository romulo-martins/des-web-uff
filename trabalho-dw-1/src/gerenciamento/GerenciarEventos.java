/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.ArrayList;
import java.util.Collections;
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

<<<<<<< HEAD
    //
    public void seedEventos(List<Evento> eventos) {
        this.eventos.addAll(eventos);
    }

    // metodo para exibir no console os eventos cadastrados
    public void listarEventos() {
        System.out.println("----- Eventos -----");
        for (Evento evento : this.eventos) {
            System.out.println(evento);
        }
    }

    public List<Evento> gerarCatalogo() {
        List<Evento> resp = new ArrayList<>();
        Collections.copy(eventos, resp);
        return resp;

    }

    





=======
    public void seedEventos(List<Evento> eventos) {
        this.eventos.addAll(eventos);
    }
    
>>>>>>> d66a54607a60a8a7b49fba670c4bb01dd8d2c99a
}
