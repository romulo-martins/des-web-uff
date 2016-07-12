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
import java.util.Calendar;
import java.util.List;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class EventoDao {

    // a conexão com o banco de dados
    private Connection connection;

    public EventoDao(Connection connection) {
        this.connection = connection;
    }

    public List<Evento> getLista() {
        List<Evento> contatos = new ArrayList<>();
        String sql = "SELECT * FROM eventos";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Evento evento = createEvento(rs);

                // adicionando o objeto à lista
                contatos.add(evento);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Evento createEvento(ResultSet rs) throws SQLException {
        // cria o objeto contato
        Evento evento = new Evento();
        evento.setId(rs.getInt("id"));
        evento.setNome(rs.getString("nome"));
        evento.setId(rs.getInt("tipo"));
        evento.setDescricao(rs.getString("descricao"));
        
//        evento.setEndereco(rs.getString("endereco"));
//
//        // montando a data através do Calendar
//        Calendar data = Calendar.getInstance();
//        data.setTime(rs.getDate("dataNascimento"));
//        evento.setDataNascimento(data);

        return evento;
    }

}
