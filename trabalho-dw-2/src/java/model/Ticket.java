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
    private String nome;

    public int getId() {
        return id;
    }

    public int getPreco() {
        return preco;
    }

    public TipoIngresso getTipoTicket() {
        return tipoTicket;
    }

    public String getNome() {
        return nome;
    }

    public Ticket(Ingresso ingresso, TipoIngresso tipoTicket) {
        this.id = (int) Math.random();
        this.preco = 25;//ingresso.getPreco();
        this.tipoTicket = tipoTicket;
        this.nome = "Show das poderosas"; //ingresso.getEvento().getNome();
    }

}
