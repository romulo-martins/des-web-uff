/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.EnderecoDao;
import java.util.List;
import jdbc.ConnectionFactory;
import model.Endereco;

/**
 *
 * @author Romulo
 */
public class EnderecoTeste {
    
    public static void main(String[] args) {
        
        EnderecoDao dao = new EnderecoDao(new ConnectionFactory().getConnection());
       
        List<Endereco> enderecos = dao.getLista();
        for(Endereco endereco : enderecos) {
            System.out.println(endereco);
        }
        
    }
    
}
