/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Cliente;
import modelo.Endereco;

/**
 *
 * @author Romulo
 */
public class GerenciarCliente {
    
    private List<Cliente> clientes;    
    private Scanner sc;
    
    public GerenciarCliente() {
        this.clientes = new ArrayList<>();
        sc = new Scanner(System.in);
    }         
    
    public void cadastrar() {
        System.out.println("----- Informe os dados do Cliente -----");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Telefone: ");
        String telefone = sc.nextLine();
        System.out.println("CPF: ");
        String cpf = sc.nextLine();
        System.out.println("Data de Nascimento: ");
        String dataDeNascimento = sc.nextLine();
        System.out.println("Endereco: ");
        
        GerenciarEndereco ge = new GerenciarEndereco();
        Endereco endereco = ge.cadastrar();
        
        Cliente cliente  = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setDataDeNascimento(dataDeNascimento);
        cliente.setEndereco(endereco);
        
        this.clientes.add(cliente);
    }
    
    public List<Cliente> obterClientesCadastrados() {
        return this.clientes;
    }
    
    public void listarClientesCadastrados() {
        System.out.println("----- Clientes Cadastrados -----");
        for(Cliente cliente : this.clientes) {
            System.out.println(cliente);
        }
    }
}
