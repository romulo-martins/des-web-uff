/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;

/**
 *
 * @author cafer
 */
public class Carrinho {

    private List<Ticket> tickets;

    public Carrinho() {
        this.tickets = new ArrayList<>();
    }

    public List<Ticket> getEntrada() {
        return tickets;
    }

    public void adicionarTicket(Ticket entrada) {
        this.tickets.add(entrada);
    }

    public void removerTicket(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id) {
               tickets.remove(t);
            }
        }
    }
}
