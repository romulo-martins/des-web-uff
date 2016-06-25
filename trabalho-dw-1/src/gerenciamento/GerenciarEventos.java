/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Evento;

/**
 *
 * @author Romulo
 */
public class GerenciarEventos {

    private List<Evento> eventos;
    private Scanner sc;

    public GerenciarEventos() {
        this.eventos = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    //
    public void seedClientes(List<Evento> eventos) {
        this.eventos.addAll(eventos);
    }

    // metodo para exibir no console os eventos cadastrados
    public void listarClientes() {
        System.out.println("----- Eventos -----");
        for (Evento evento : this.eventos) {
            System.out.println(evento);
        }
    }

}
