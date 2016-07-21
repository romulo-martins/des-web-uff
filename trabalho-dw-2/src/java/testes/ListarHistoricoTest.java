/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.HistoricoDao;
import java.util.List;
import model.Historico;

/**
 *
 * @author Romulo
 */

public class ListarHistoricoTest {
    
    public static void main(String[] args) {
        HistoricoDao dao = new HistoricoDao();
        List<Historico> historico = dao.busca(3);
        for(Historico linhaHistorico : historico) {
            System.out.println(linhaHistorico);
        }
        
    }
}
