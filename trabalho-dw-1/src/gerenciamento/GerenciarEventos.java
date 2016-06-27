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
import modelo.Ingresso;

/**
 *
 * @author Romulo
 */

public class GerenciarEventos {

    private List<Evento> eventos;

    public GerenciarEventos() {
        this.eventos = new ArrayList<>();
    }

    // 
    public void seedEventos(List<Evento> eventos) {
        this.eventos.addAll(eventos);
    }

    // metodo para exibir no console os eventos cadastrados
    public void listarEventos() {
        for (Evento evento : this.eventos) {
            System.out.println(evento);
        }
    }
    
    public Evento getEvento(int id) {
        return this.eventos.get(id - 1);
    }
    
    public Ingresso getIngresso(int idEvento) {
        Evento evento = this.eventos.get(idEvento - 1);
        int quantidadeDeIngressos = evento.getQuantidadeDeIngressos();
        evento.setQuantidadeDeIngressos(quantidadeDeIngressos - 1);
        return evento.getIngresso();
    }
    
    public List<Evento> gerarCatalogo() {
        List<Evento> resp = new ArrayList<>();
        Collections.copy(eventos, resp);
        return resp;

    }

}
