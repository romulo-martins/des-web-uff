/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.logica;

import dao.HistoricoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Carrinho;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author cafer
 */
public class PagamentoLogic implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        Usuario usuario = (Usuario) req.getSession().getAttribute("usuario");
        Carrinho carrinho = (Carrinho) req.getSession().getAttribute("carrinho");
        
        HistoricoDao dao = new HistoricoDao();
        dao.adicionarCompra(carrinho, usuario.getCliente());
        return "compraSuccess.jsp";
    }
    
    
    
}
