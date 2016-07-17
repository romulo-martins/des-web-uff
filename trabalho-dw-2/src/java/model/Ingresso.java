/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import tipos.TipoIngresso;

/**
 *
 * @author Romulo
 */
public class Ingresso {
    
    private int id;
    private int preco;
    private Evento evento;
    private final TipoIngresso tipo;

    public Ingresso(int id, int preco, TipoIngresso tipo, Evento evento) {
        this.id = id;
        this.preco = preco;
        this.tipo = tipo;
        this.evento = evento;
    }

    public Ingresso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
}
