/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gerenciamento;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Ingresso;

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
    
    public List<Ingresso> getIngressos() {
        List<Ingresso> resp = new ArrayList<>();
        Collections.copy(this.ingressos, resp);
        return resp;
    }
    
    @Override
    public String toString() {
        String resp = "";
        for(Ingresso ingresso : this.ingressos) {
            resp += "Nome: " + ingresso.getEvento().getNome() + ", " 
                   + "Valor: " + ingresso.getPreco() + "\n";
        }
        return resp;
    }
    
}
