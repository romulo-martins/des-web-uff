/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


/**
 *
 * @author Romulo
 */
public class Ingresso {

    private int id;
    private int preco;
    private int qtdEstoque;

    public Ingresso(int preco, int qtdEstoque, Evento evento) {
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
        this.evento = evento;
    }
    
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    private Evento evento;
    //private final TipoIngresso tipo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreco() {
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
