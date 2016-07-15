/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import jdbc.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cliente;
import model.Usuario;

/**
 *
 * @author Romulo
 */
public class UsuarioDao {

    // a conexão com o banco de dados
    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public Usuario getUsuario(String uname) {
        String sql = "SELECT * "
                + "FROM usuario "
                + "WHERE uname = ?";

        Usuario usuario = null;
        try {         
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, uname);
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            usuario = new Usuario(rs.getString("uname"), rs.getString("password"));
            
            int clienteId = rs.getInt("cliente_id");
            ClienteDao dao = new ClienteDao();
            Cliente cliente = dao.busca(clienteId);
            usuario.setCliente(cliente);
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }

}
