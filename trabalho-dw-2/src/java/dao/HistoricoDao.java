/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import jdbc.ConnectionFactory;
import model.Historico;

/**
 *
 * @author Romulo
 */
public class HistoricoDao {

    private Connection connection;

    public HistoricoDao() {
        this.connection = new ConnectionFactory().getConnection();
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
        return linhaHistorico;
    }

}
