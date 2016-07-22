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
import jdbc.ConnectionFactory;
import model.Evento;
import model.IngressoFactory;

/**
 *
 * @author Romulo
 */
public class IngressoFactoryDao {

    // a conexão com o banco de dados
    private Connection connection;

    public IngressoFactoryDao(Connection connection) {
        this.connection = connection;
    }

    public IngressoFactoryDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public IngressoFactory getFactory(Evento evento) {
        String sql = "SELECT * FROM ingresso_factory WHERE evento_id=?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, evento.getId());
            ResultSet rs = stmt.executeQuery();

            rs.next();

            // criando o objeto Contato
            IngressoFactory ingressoFactory = createIngressoFactory(rs, evento);

            rs.close();
            stmt.close();
            return ingressoFactory;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private IngressoFactory createIngressoFactory(ResultSet rs, Evento evento) throws SQLException {
        // cria o objeto contato
        IngressoFactory ingressoFactory = new IngressoFactory();
        ingressoFactory.setId(rs.getInt("id"));
        ingressoFactory.setValorIngresso(rs.getDouble("valor_ingresso"));
        ingressoFactory.setQuantidadeIngresso(rs.getInt("quantidade_ingressos"));
        ingressoFactory.setEvento(evento);
        return ingressoFactory;
    }

    public void updateEstoque(Evento evento, String tipo) {
        String sql=null;
        if (tipo.equals("REMOVER")) {
            sql = "UPDATE ingresso_factory SET quantidade_ingressos=quantidade_ingressos-1 WHERE evento_id=?";
        } else if (tipo.equals("ADICIONAR")) {
            sql = "UPDATE ingresso_factory SET quantidade_ingressos=quantidade_ingressos+1 WHERE evento_id=?";
        }
        
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, evento.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
