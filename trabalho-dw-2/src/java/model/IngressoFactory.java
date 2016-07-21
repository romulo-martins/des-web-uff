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
public class IngressoFactory {
    
    private int id;
    private double valorIngresso;
    private int quantidadeIngresso;
    private Evento evento;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getQuantidadeIngresso() {
        return quantidadeIngresso;
    }

    public void setQuantidadeIngresso(int quantidadeIngresso) {
        this.quantidadeIngresso = quantidadeIngresso;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    
    
    public Ingresso gerarIngresso(TipoIngresso tipo) {
        if(this.quantidadeIngresso > 0) {
            Ingresso ingresso = new Ingresso();
            ingresso.setEvento(evento);
            ingresso.setTipo(tipo);
            if(tipo == TipoIngresso.Meia) {
                ingresso.setValorPago(this.valorIngresso / 2);
            }
            else {
                ingresso.setValorPago(valorIngresso);
            }
            return ingresso;
        }
        return null;
    }
    
    
}
