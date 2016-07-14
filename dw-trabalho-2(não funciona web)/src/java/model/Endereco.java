/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Romulo
 */
public class Endereco {
    
    private int id;
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    
    @Override
    public String toString() {
        return "Rua: " + getRua() + "\n" +
                "Bairro: " + getBairro() + "\n" +
                "Cidade: " + getCidade() + "\n" +
                "Estado: " + getEstado() + "\n" +
                "Complemento: " + getComplemento() + "\n";
    }
    
}
