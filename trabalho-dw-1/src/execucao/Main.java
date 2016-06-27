/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package execucao;

import dados.Seed;
import gerenciamento.GerenciarCliente;
import gerenciamento.GerenciarEventos;
import gerenciamento.Sessao;
import modelo.Cliente;

/**
 *
 * @author Romulo
 */
public class Main {

    public static void main(String[] args) {

        // responsavel pelas operações de eventos
        GerenciarEventos ge = new GerenciarEventos();
        //popula com dados de exemplo
        ge.seedEventos(Seed.getEventos());
        // exibe os eventos
        System.out.println("----- Eventos -----");
        ge.listarEventos();

        GerenciarCliente gc = new GerenciarCliente();
        // popula com os dados de exemplo
        gc.seedClientes(Seed.getClientes());

        // suponha que o cliente 3 (Flavia Almeida) quer comprar ingressos
        Cliente c = gc.getCliente(3);
        System.out.println("----- Cliente selecionado -----");
        System.out.println(c);

        //Flavia faz login para iniciar sessão
        Sessao se = new Sessao();
        se.fazerLogin(c.getNome(), c.getSenha());

        // Flavia escolhe uma das opções de evento e adciona no carrinho de compras
        System.out.println("Catálogo");
        se.exibirCatalogo();
        se.adcionarNoCarrinho(4, 1);

        //Flavia confirma a compra e efetua o pagamento
        se.finalizarCompra();
        se.efetuarPagamento();
        
        //Flavia verifica o histórico para ver sa compra foi feita
        System.out.println("Histórico");
        se.exibirHistorico();
                
    }
}
