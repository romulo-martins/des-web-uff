/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Romulo
 */
public class CarrinhoDeCompra {
    
    private List<Ingresso> ingressos;
    
    public CarrinhoDeCompra() {
        this.ingressos = new ArrayList<>();
    }
    
    public void adicionar(Ingresso ingresso) {
        this.ingressos.add(ingresso);
    }
    
    public void remover(Ingresso ingresso) {
        this.ingressos.remove(ingresso);
    }
    
}
