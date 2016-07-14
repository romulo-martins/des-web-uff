/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import model.Evento;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Romulo
 */
public class RequestToEvento {

    public static Evento executa(HttpServletRequest req, HttpServletResponse res, TipoCRUD tipoCrud) throws IOException {
        // busca o writer
        PrintWriter out = res.getWriter();

        // buscando os parâmetros no request
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");
        String data = req.getParameter("data");
        String hora = req.getParameter("hora");
        String local = req.getParameter("local");

        // monta um objeto contato
        Evento evento = new Evento();
        if(tipoCrud == TipoCRUD.Altera) { 
            int id = Integer.parseInt(req.getParameter("id"));
            evento.setId(id);
        }        
        evento.setNome(nome);
        evento.setDescricao(descricao);
        evento.setHora(hora);
        evento.setLocal(local);
        
        return evento;
    }

}
