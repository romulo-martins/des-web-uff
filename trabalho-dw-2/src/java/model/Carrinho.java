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
    
    private List<Ticket> entrada; 

    public Carrinho() {
        this.entrada = new ArrayList<>();
    }

    public List<Ticket> getEntrada() {
        return entrada;
    }
    
    public void AdicionarCarrinho(Ticket entrada){
        this.entrada.add(entrada);
    }
}
