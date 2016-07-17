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
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionFactory;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class EventoDao {

    private Connection connection;

    public EventoDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Evento evento) {
        String sql = "INSERT INTO evento "
                + "(nome, descricao, data_evento, hora, local_evento)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, evento.getNome());
            stmt.setString(2, evento.getDescricao());
            stmt.setString(3, evento.getData());
            stmt.setString(4, evento.getHora());
            stmt.setString(5, evento.getLocal());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void remove(Evento evento) {
        String sql = "DELETE FROM evento WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, evento.getId());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Evento busca(int id) {
        String sql = "SELECT * "
                + "FROM evento "
                + "WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.next();
            Evento evento = createEvento(rs);

            rs.close();
            stmt.close();
            return evento;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Evento> getLista() {
        List<Evento> eventos = new ArrayList<>();
        String sql = "SELECT * FROM evento";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Evento evento = createEvento(rs);

                // adicionando o objeto à lista
                eventos.add(evento);
            }
            rs.close();
            stmt.close();
            return eventos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Evento createEvento(ResultSet rs) throws SQLException {
        // cria o objeto evento
        Evento evento = new Evento();
        evento.setId(rs.getInt("id"));
        evento.setNome(rs.getString("nome"));
        evento.setDescricao(rs.getString("descricao"));
        evento.setData(rs.getString("data_evento"));
        evento.setHora(rs.getString("hora"));
        evento.setImagem(rs.getString("imagem"));
        evento.setLocal(rs.getString("local_evento"));
        return evento;
    }

}
