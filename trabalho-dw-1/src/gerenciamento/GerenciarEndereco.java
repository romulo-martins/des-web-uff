/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.Scanner;
import modelo.Endereco;

/**
 *
 * @author Romulo
 */
public class GerenciarEndereco {

    private Scanner sc;
    
    public GerenciarEndereco() {
        this.sc = new Scanner(System.in);
    }
    
    public Endereco cadastrar() {
        System.out.println("----- Informe os dados do Endereco -----");
        System.out.println("Rua: ");
        String rua = sc.nextLine();
        System.out.println("Bairro: ");
        String bairro = sc.nextLine();
        System.out.println("Cidade: ");
        String cidade = sc.nextLine();
        System.out.println("Estado: ");
        String estado = sc.nextLine();
        System.out.println("CEP: ");
        String cep = sc.nextLine();
        System.out.println("Complemento: ");
        String complemento = sc.nextLine();
        
        Endereco endereco = new Endereco();
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        
        return endereco;
    }    
}
