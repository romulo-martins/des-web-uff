/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ClienteDao;
import dao.EventoDao;
import dao.HistoricoDao;
import dao.IngressoFactoryDao;
import java.sql.Date;
import java.util.Calendar;
import model.Carrinho;
import model.Cliente;
import model.Evento;
import model.IngressoFactory;
import tipos.TipoIngresso;

/**
 *
 * @author Romulo
 */
public class AdicionaHistorico {
    
    public static void main(String[] args) {
        Evento evento = new EventoDao().busca(2);
        IngressoFactory ingressoFactory = new IngressoFactoryDao().getFactory(evento);
        
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(ingressoFactory.gerarIngresso(TipoIngresso.Meia));
        carrinho.adicionar(ingressoFactory.gerarIngresso(TipoIngresso.Meia));
        carrinho.adicionar(ingressoFactory.gerarIngresso(TipoIngresso.Inteira));
        
        Cliente cliente = new ClienteDao().busca(2);
        Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());
        
        HistoricoDao dao = new HistoricoDao();
        dao.adicionarCompra(carrinho, cliente);
    }
    
}
