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
import model.Endereco;

/**
 *
 * @author Romulo
 */
public class EnderecoDao {

    // a conexão com o banco de dados
    private Connection connection;

    public EnderecoDao(Connection connection) {
        this.connection = connection;
    }
    
        public void adiciona(Endereco endereco) {
        String sql = "INSERT INTO enderecos "
                + "(rua, bairro, cidade, estado, complemento)"
                + " VALUES (?, ?, ?, ?, ?)";

        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getComplemento());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void altera(Endereco endereco) {
        String sql = "UPDATE enderecos SET rua=?, bairro=?,"
                + "cidade=?, estado=?, complemento=? WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getBairro());
            stmt.setString(3, endereco.getCidade());
            stmt.setString(4, endereco.getEstado());
            stmt.setString(5, endereco.getComplemento());
            stmt.setLong(6, endereco.getId());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(Endereco endereco) {
        String sql = "DELETE FROM enderecos WHERE id=?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, endereco.getId());

            // executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // faz a pesquisa pelo id
    public Endereco busca(int id) {
        String sql = "SELECT * FROM enderecos WHERE id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            rs.next();

            // criando o objeto Contato
            Endereco endereco = createEndereco(rs);

            rs.close();
            stmt.close();
            return endereco;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Endereco> getLista() {
        List<Endereco> enderecos = new ArrayList<>();
        String sql = "SELECT * FROM enderecos";

        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                // criando o objeto Contato
                Endereco endereco = createEndereco(rs);

                // adicionando o objeto à lista
                enderecos.add(endereco);
            }
            rs.close();
            stmt.close();
            return enderecos;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Endereco createEndereco(ResultSet rs) throws SQLException {
        // cria o objeto contato
        Endereco endereco = new Endereco();
        endereco.setId(rs.getInt("id"));
        endereco.setRua(rs.getString("rua"));
        endereco.setBairro(rs.getString("bairro"));
        endereco.setCidade(rs.getString("cidade"));
        endereco.setEstado(rs.getString("estado"));

        return endereco;
    }
}
