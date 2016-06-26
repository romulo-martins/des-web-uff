/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import gerenciamento.CarrinhoDeCompra;
import tipos.TipoPagamento;

/**
 *
 * @author Romulo
 */

public class Compra {
    
    private int id;
    private String dataDaCompra; // mudar para Date
    private TipoPagamento tipoDePagamento; // 
    private CarrinhoDeCompra carrinho;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataDaCompra() {
        return dataDaCompra;
    }

    public void setDataDaCompra(String dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }

    public TipoPagamento getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(TipoPagamento tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }
    
    public CarrinhoDeCompra getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoDeCompra carrinho) {
        this.carrinho = carrinho;
    }
    
    public int getValorTotalDaCompra() {
        int valor = 0;
        for(Ingresso ingresso : this.carrinho.getIngressos()) {
            valor += ingresso.getPreco();
        }        
        return valor;
    }
    
    @Override
    public String toString() {
        return "Cod: " + getId() + "\n" + 
                "Data da compra: " + getDataDaCompra() + "\n" + 
                "Tipo de pagamento: " + getTipoDePagamento() + "\n" + 
                "Carrinho de compra: " + getCarrinho().toString() + "\n" + 
                "Valor total(R$): " + getValorTotalDaCompra() + "\n" ;
    }
}
