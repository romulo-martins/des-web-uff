/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import tipos.TipoIngresso;

/**
 *
 * @author cafer
 */
public class Ticket {
    
    private int id;
    private int preco;
    private TipoIngresso tipoTicket;

    public Ticket(Ingresso ingresso, TipoIngresso tipoTicket) {
        this.preco = ingresso.getPreco();
        this.tipoTicket = tipoTicket;
    }
    
}
