/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import tipos.TipoEvento;

/**
 *
 * @author Romulo
 */

@Entity
public class Evento {
    
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private TipoEvento tipo;
    private String descricao;
    private String data; // muda para Date?
    private String hora; // muda para Date?
    private String local;    
    
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
                "Local: " + getLocal() + "\n";
    }
}
