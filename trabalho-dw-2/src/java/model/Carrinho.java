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
        return ingressos;
    }
    
    public void AdicionarCarrinho(Ingresso ingresso){
        ingressos.add(ingresso);
    }
}
