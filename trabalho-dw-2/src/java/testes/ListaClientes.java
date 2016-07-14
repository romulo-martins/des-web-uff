/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ClienteDao;
import java.util.List;
import model.Cliente;

/**
 *
 * @author Romulo
 */
public class ListaClientes {

    public static void main(String[] args) {
        ClienteDao dao = new ClienteDao();
        List<Cliente> clientes = dao.getLista();
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

}
