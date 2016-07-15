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
public class Historico {
    
    private int id;
    private String dataCompra;
    private double valorCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    
    @Override
    public String toString() {
        return "Data da compra: " + getDataCompra() + "\n" + 
                "Valor total da compra: "+ getValorCompra() + "\n";
    }
    
}
