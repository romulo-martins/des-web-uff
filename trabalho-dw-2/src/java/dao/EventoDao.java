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
                + "(nome, descricao, data, hora, local)"
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

    private Evento createEvento(ResultSet rs) throws SQLException {
        // cria o objeto contato
        Evento contato = new Evento();
        contato.setId(rs.getInt("id"));
        contato.setNome(rs.getString("nome"));
        contato.setDescricao(rs.getString("descricao"));
        contato.setData("data");
        contato.setLocal(rs.getString("local"));
        contato.setHora(rs.getString("hora"));
        return contato;
    }

}
