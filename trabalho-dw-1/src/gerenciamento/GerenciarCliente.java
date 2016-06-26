/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Romulo
 */
public class GerenciarCliente {
    
    private List<Cliente> clientes;    
    
    public GerenciarCliente() {
        this.clientes = new ArrayList<>();
    }   
    
    public void cadastrar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    // metodo para popular a base de clientes
    public void seedClientes(List<Cliente> clientes) {
        this.clientes.addAll(clientes);
    }
    
}
