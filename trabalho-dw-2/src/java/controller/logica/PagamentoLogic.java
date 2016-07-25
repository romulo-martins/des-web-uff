/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.HistoricoDao;
import dao.IngressoDao;
import dao.IngressoFactoryDao;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
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
        if (req.getParameter("ncartao").isEmpty()  || req.getParameter("nseguranca").isEmpty()) {
            String msgObg = "Preencha os campos obrigatórios.";
            req.setAttribute("msgObg", msgObg);
            return "forma-pagamento.jsp";
        }
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Carrinho carrinho = (Carrinho) req.getSession().getAttribute("carrinho");

        // obtem da requisição a conexão do banco de dados
        Connection connection = (Connection) req.getAttribute("conexao");

        HistoricoDao dao = new HistoricoDao(connection);
        IngressoFactoryDao factory = new IngressoFactoryDao();
        List<Ingresso> auxCarrinho = new ArrayList<>();
        String msgErro = "";
        String msgSuccess = "";
        String msgCarrinho = "";
        int qtd = 0;
        int qtdTotal;

        for (Ingresso i : carrinho.getIngressos()) {
            qtdTotal = qtdIngresso(carrinho, i.getEvento().getId())
                    + dao.getQtdEvento(usuario.getCliente().getId(), i.getEvento().getId());
            if (qtdTotal > 4) {
                auxCarrinho.add(i);
                msgCarrinho += "<br>O Evento não pode ser comprado:" + i.getEvento().getNome() + "</br>";
            }
        }
        carrinho.getIngressos().removeAll(auxCarrinho);

        dao.adicionarCompra(carrinho, usuario.getCliente());
        for (Ingresso i : carrinho.getIngressos()) {
            if (factory.getFactory(i.getEvento()).getQuantidadeIngresso() > 0) {
                factory.updateEstoque(i.getEvento(), "REMOVER");
                msgSuccess += "<br>Compra confirmada:" + i.getEvento().getNome() + "</br>";
            } else {
                msgErro += "Ingresso esgotado:" + i.getEvento().getNome() + "\n";
            }
        }

        // reseta o carrinho
        carrinho.getIngressos().clear();
        carrinho.getIngressos().addAll(auxCarrinho);
        req.setAttribute("msgSuccess", msgSuccess);
        req.setAttribute("msgErro", msgErro);
        req.setAttribute("msgCarrinho", msgCarrinho);
        return "status-compra.jsp";
    }

    private int qtdIngresso(Carrinho carrinho, int idEvento) {
        int qtd = 0;
        for (Ingresso i : carrinho.getIngressos()) {
            if (i.getEvento().getId() == idEvento) {
                qtd++;
            }
        }
        return qtd;
    }
}
