/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

/**
 *
 * @author Romulo
 */
public class UserDao {

    // a conexão com o banco de dados
    private Connection connection;

    public UserDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public User getUser(String uname) {
        String sql = "SELECT * "
                + "FROM users "
                + "WHERE uname = ?";

        User user = null;
        try {         
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, uname);
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            // criando o objeto Contato
            user = new User(rs.getString("uname"), rs.getString("password"));
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}
