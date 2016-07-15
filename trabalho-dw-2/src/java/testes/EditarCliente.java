/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ClienteDao;
import model.Cliente;

/**
 *
 * @author Romulo
 */
public class EditarCliente {

    public static void main(String[] args) {

        ClienteDao dao = new ClienteDao();
        Cliente cliente = dao.busca(3);
        System.out.println(cliente);
        
        //altera o cliente
        cliente.setDataDeNascimento("18/11/1994");
        dao.altera(cliente);
        
        System.out.println("mudei!!!");

    }

}
