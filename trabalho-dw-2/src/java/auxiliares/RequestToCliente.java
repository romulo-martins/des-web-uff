/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliares;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cliente;

/**
 *
 * @author Romulo
 */
public class RequestToCliente {

    public static Cliente executa(HttpServletRequest req, HttpServletResponse res, TipoCRUD tipoCrud) throws IOException {
        // buscando os parâmetros no request
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String telefone = req.getParameter("telefone");
        String data = req.getParameter("data_nascimento");

        // monta um objeto contato
        Cliente cliente = new Cliente();
        if (tipoCrud == TipoCRUD.Altera) {
            int id = Integer.parseInt(req.getParameter("id"));
            cliente.setId(id);
        }
        cliente.setNome(nome);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setDataDeNascimento(data);

        return cliente;
    }

}
