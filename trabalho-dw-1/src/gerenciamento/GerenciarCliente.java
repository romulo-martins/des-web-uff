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

    public Cliente getCliente(int id) {
        return this.clientes.get(id - 1);
    }

    public Cliente getCliente(String nome) {
        for (Cliente c : this.clientes) {
            if (c.getNome().contains(nome)) {
                return c;
            }
        }
        return null;
    }

    public Cliente getUsuario(String nome) {
        for (Cliente c : this.clientes) {
            if (c.getUsuario().contains(nome)) {
                return c;
            }
        }
        return null;
    }

    // metodo para popular a base de clientes
    public void seedClientes(List<Cliente> clientes) {
        this.clientes.addAll(clientes);
    }

}
