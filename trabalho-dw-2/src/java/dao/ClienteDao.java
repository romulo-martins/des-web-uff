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
import model.Cliente;
import model.Evento;

/**
 *
 * @author Romulo
 */
public class ClienteDao {

    // a conexão com o banco de dados
    private Connection connection;

    public ClienteDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Cliente busca(int id) {
        String sql = "SELECT * "
                + "FROM cliente "
                + "WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.next();

            // criando o objeto Contato
            Cliente cliente = createCliente(rs);

            rs.close();
            stmt.close();
            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Cliente> getLista() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Cliente cliente = createCliente(rs);

                // adicionando o objeto à lista
                clientes.add(cliente);
            }
            rs.close();
            stmt.close();
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Cliente createCliente(ResultSet rs) throws SQLException {
        // cria o objeto contato
        Cliente cliente = new Cliente();
        cliente.setId(rs.getInt("id"));
        cliente.setNome(rs.getString("nome"));
        cliente.setEmail(rs.getString("email"));
        cliente.setTelefone(rs.getString("telefone"));
        cliente.setDataDeNascimento(rs.getString("data_nascimento"));

        return cliente;
    }

}
