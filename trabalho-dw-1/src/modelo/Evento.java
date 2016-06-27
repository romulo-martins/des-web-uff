/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import tipos.TipoEvento;

/**
 *
 * @author Romulo
 */

public class Evento {
    
    private int id;
    private String nome;
    private TipoEvento tipo;
    private String descricao;
    private String data; // muda para Date?
    private String hora; // muda para Date?
    
    private int idLocal; // chave estrangeira de local
    private String local; // mudei a classe para tipo String para cortar o scopo
    
    private int quantidadeDeIngressos;
    
    private int idIngresso;
    private Ingresso ingresso;

    public int getIdIngresso() {
        return idIngresso;
    }

    public void setIdIngresso(int idIngresso) {
        this.idIngresso = idIngresso;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getQuantidadeDeIngressos() {
        return quantidadeDeIngressos;
    }

    public void setQuantidadeDeIngressos(int quantidadeDeIngressos) {
        this.quantidadeDeIngressos = quantidadeDeIngressos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public void setTipo(TipoEvento tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return LocalDate.now().toString();
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    @Override
    public String toString() {
        return "Cod: " + getId() + "\n" +
                "Nome: " + getNome() + "\n" +
                "Tipo: " + getTipo() + "\n" +
                "Descrição: " + getDescricao() + "\n" +
                "Data: " + getData() + "\n" +
                "Hora: " + getHora() + "\n" +
                "Local: " + getLocal() + "\n" + 
                "Quantidade de Ingressos: " + getQuantidadeDeIngressos()+ "\n";
    }
}
