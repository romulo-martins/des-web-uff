/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jdbc.ConnectionFactory;
import model.Carrinho;
import model.Cliente;
import model.Historico;
import model.Ingresso;

/**
 *
 * @author Romulo
 */
public class HistoricoDao {

    private Connection connection;

    public HistoricoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public HistoricoDao(Connection connection) {
        this.connection = connection;
    }

    public void adicionarCompra(Carrinho carrinho, Cliente cliente) {
        String sql = "INSERT INTO historico(data_compra, valor_compra, cod_compra, cliente_id) "
                + "VALUES(?, ?, ?, ?)";
        
        Date dataAtual = new Date(Calendar.getInstance().getTimeInMillis());
        int codigoCompra = getCodigoCompra(cliente.getId(), carrinho.valorCompra(), dataAtual);
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setDate(1, dataAtual);
            stmt.setDouble(2, carrinho.valorCompra());
            stmt.setInt(3, codigoCompra);
            stmt.setInt(4, cliente.getId());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        adicionaIngressosComprados(carrinho, codigoCompra);

    }

    public List<Historico> busca(int idCliente) {
        List<Historico> historico = new ArrayList<>();
        String sql = "SELECT * FROM historico WHERE cliente_id = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Historico linhaHistorico = createHistorico(rs);

                historico.add(linhaHistorico);
            }
            rs.close();
            stmt.close();
            return historico;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Historico createHistorico(ResultSet rs) throws SQLException {
        Historico linhaHistorico = new Historico();
        linhaHistorico.setId(rs.getInt("id"));
        linhaHistorico.setDataCompra(rs.getString("data_compra"));
        linhaHistorico.setValorCompra(rs.getDouble("valor_compra"));
        linhaHistorico.setCodCompra(rs.getInt("cod_compra"));
        return linhaHistorico;
    }

    private int getCodigoCompra(int id, double valorCompra, Date dataAtual) {
        return Math.abs((id + valorCompra + dataAtual.toString()).hashCode());
    }

    private void adicionaIngressosComprados(Carrinho carrinho, int codigoCompra) {
        String sql = "INSERT INTO ingressos_comprados(codigo_compra, ingresso_id) "
                + "VALUES(?, ?)";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            for(Ingresso ingresso : carrinho.getIngressos()) {
                stmt.setInt(1, codigoCompra);
                stmt.setDouble(2, ingresso.getId());
                stmt.execute();                
            }

            // executa
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
