/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author cafer
 */
public class Carrinho {

    private List<Ingresso> ingressos;

    public Carrinho() {
        this.ingressos = new ArrayList<>();
    }

    public List<Ingresso> getIngressos() {
        return this.ingressos;
    }
    
    public void adicionar(Ingresso ingresso){
        this.ingressos.add(ingresso);
    }
    public boolean remover(int id) {
        for (Ingresso i : ingressos) {
            if (i.getId() == id) {
               ingressos.remove(id);
               return true;
            }
        }
        return false;
    }
    
     public Ingresso getIngresso(int id) {
        for (Ingresso i : ingressos) {
            if (i.getId() == id) {
               return i;
            }
        }
        return null;
    }
    
    // valor total da compra
    public double valorCompra() {
        double valorTotal = 0;
        for(Ingresso ingresso : this.ingressos) {
            valorTotal += ingresso.getValorPago();
        }
        return valorTotal;
    }
}
