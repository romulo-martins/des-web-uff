/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.HistoricoDao;
import dao.IngressoFactoryDao;
import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Ingresso;
import model.Usuario;

/**
 *
 * @author cafer
 */
public class PagamentoLogic implements Logica {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Carrinho carrinho = (Carrinho) req.getSession().getAttribute("carrinho");
        
        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");
        
        HistoricoDao dao = new HistoricoDao(connection);
        IngressoFactoryDao factory = new IngressoFactoryDao();
        String msgErro = "";
        String msgSuccess = "";
        dao.adicionarCompra(carrinho, usuario.getCliente());
        for (Ingresso i : carrinho.getIngressos()) {
            if (factory.getFactory(i.getEvento()).getQuantidadeIngresso() > 0) {
                factory.updateEstoque(i.getEvento(), "REMOVER");
                msgSuccess += "<br>Compra confirmada:" + i.getEvento().getNome() + "</br>";
            }else{
                msgErro += "Ingresso esgotado:" + i.getEvento().getNome() + "\n";
            }
        }
        // reseta o carrinho
        carrinho.getIngressos().clear();
        req.setAttribute("msgSuccess", msgSuccess);
        req.setAttribute("msgErro", msgErro);
        return "status-compra.jsp";
    }

}
