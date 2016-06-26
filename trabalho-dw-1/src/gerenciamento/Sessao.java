/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.List;
import modelo.*;

/**
 *
 * @author Carrara
 */
public class Sessao {

    private Cliente client;
    private CarrinhoDeCompra kart;
    private GerenciarCliente gerenteCliente;
    private GerenciarEventos gerenteEvento;

    public boolean fazerLogin(String usuario, String senha) {
        client = gerenteCliente.getCliente(usuario);
        return client != null && client.getSenha().equals(senha);
    }

    public void exibirHistorico() {
        List<Compra> compras = client.getHistorico().getHistoricoDeCompras();
        for (Compra c : compras) {
            System.out.println(c.toString());
        }
    }

    public void exibirCatalogo() {
        List<Evento> eventos = gerenteEvento.gerarCatalogo();
        System.out.println("Eventos disponíveis:");
        for (Evento e : eventos) {
            e.toString();
            System.out.println("");
        }

    }
    
    public boolean adcionarNoCarrinho(int eventoID, int qtd){
        if (qtd < 4) {
            return false;
        }
        
        for (int i = 0; i < qtd-1; i++) {
            kart.adicionar(gerenteEvento.getIngresso(eventoID));
        }
        
        return true;
    }
    
    
}
