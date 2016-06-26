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
public class Historico {  
    
    private List<Compra> compras;
    
    public Historico() {
        this.compras = new ArrayList<>();
    }
    
    public void adiciona(Compra compra) {
        this.compras.add(compra);
    }
    
    public List<Compra> getHistoricoDeCompras() {
        return this.compras;
    }
    
}
