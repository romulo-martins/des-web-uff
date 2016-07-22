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
import model.Evento;
import model.Ingresso;
import tipos.TipoIngresso;

/**
 *
 * @author Romulo
 */
public class IngressoDao {

    private Connection connection;

    public IngressoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public IngressoDao(Connection connection) {
        this.connection = connection;
    }

    public void adiciona(Ingresso ingresso) {
        String sql = "INSERT INTO ingresso "
                + "(valor_pago, tipo_evento, cod_compra, evento_id)"
                + " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, ingresso.getValorPago());
            stmt.setInt(2, ingresso.getTipo().ordinal());
            stmt.setInt(3, ingresso.getCodCompra());
            stmt.setInt(4, ingresso.getEvento().getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Ingresso busca(int id) {
        String sql = "SELECT * FROM ingresso WHERE id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            // criando o objeto Contato
            Ingresso ingresso = createIngresso(rs);

            rs.close();
            stmt.close();
            return ingresso;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Ingresso> getIngressos(int codCompra) {
        List<Ingresso> ingressos = new ArrayList<>();
        String sql = "SELECT * FROM ingresso WHERE cod_compra = ?";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, codCompra);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Ingresso ingresso = createIngresso(rs);
                ingresso.setCodCompra(codCompra);
                ingressos.add(ingresso);
            }
            rs.close();
            stmt.close();
            return ingressos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Ingresso createIngresso(ResultSet rs) throws SQLException {
        Ingresso ingresso = new Ingresso();
        ingresso.setId(rs.getInt("id"));
        ingresso.setValorPago(rs.getDouble("valor_pago"));
        ingresso.setTipo(TipoIngresso.getTipo(rs.getInt("tipo_evento")));
        Evento evento = new EventoDao().busca(rs.getInt("evento_id"));
        ingresso.setEvento(evento);
        return ingresso;
    }

}
