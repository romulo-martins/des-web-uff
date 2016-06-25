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
        String endereco = sc.nextLine();
        
        
        Cliente cliente  = new Cliente();
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setCpf(cpf);
        cliente.setDataDeNascimento(dataDeNascimento);
        cliente.setEndereco(endereco);
        
        this.clientes.add(cliente);
    }

    // metodo para popular a base de clientes
    public void seedClientes(List<Cliente> clientes) {
        this.clientes.addAll(clientes);
    }
    
    // metodo para exibir no console os clientes cadastrados
    public void listarClientes() {
        System.out.println("----- Clientes Cadastrados -----");
        for(Cliente cliente : this.clientes) {
            System.out.println(cliente);
        }
    }
}
