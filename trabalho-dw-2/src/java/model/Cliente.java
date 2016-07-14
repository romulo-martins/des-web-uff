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
public class Cliente {

    private int id;
    private String nome;
    private String email;
    private String telefone;
    private String dataDeNascimento; // deixei como String para facilitar mais dps podemos trocar para Calendar
    private String cpf;    
    
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cod: " + getId() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Email: " + getEmail() + "\n"
                + "Telefone: " + getTelefone() + "\n"
                + "Data de nascimento: " + getDataDeNascimento() + "\n"
                + "CPF: " + getCpf() + "\n";
    }


}
