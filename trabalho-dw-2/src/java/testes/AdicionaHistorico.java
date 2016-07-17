/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ClienteDao;
import dao.HistoricoDao;
import java.sql.Date;
import java.util.Calendar;
import model.Carrinho;
import model.Cliente;
import model.Ingresso;
import tipos.TipoIngresso;

/**
 *
 * @author Romulo
 */
public class AdicionaHistorico {
    
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Ingresso(1, 340, TipoIngresso.Inteira, null));
        carrinho.adicionar(new Ingresso(2, 250, TipoIngresso.Inteira, null));
        carrinho.adicionar(new Ingresso(3, 80, TipoIngresso.Meia, null));
        
        Cliente cliente = new ClienteDao().busca(2);
        Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());
        
        HistoricoDao dao = new HistoricoDao();
        dao.adicionarCompra(carrinho, cliente);
    }
    
}
