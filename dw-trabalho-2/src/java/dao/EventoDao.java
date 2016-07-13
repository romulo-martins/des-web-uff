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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Evento;
import tipos.TipoEvento;

/**
 *
 * @author Romulo
 */
public class EventoDao {

        private EntityManagerFactory factory;
        private EntityManager manager;
        
    public EventoDao() {
        factory = Persistence.createEntityManagerFactory("dw-trabalho-2");
        manager = factory.createEntityManager();
    }

    public void adiciona(Evento evento) {
        manager.getTransaction().begin();

        manager.persist(evento);

        manager.getTransaction().commit();

        manager.close();
        factory.close();
    }

    public List<Evento> getLista() {
        //cuidado, use o import javax.persistence.Query
        Query query = manager.createQuery("SELECT * FROM evento");

        List<Evento> lista = query.getResultList();

        manager.close();

        return lista;
    }

}
