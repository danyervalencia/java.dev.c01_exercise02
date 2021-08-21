package com.java.dev01.exercise02.pruebas;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.java.dev01.exercise02.util.HibernateUtil;

import com.java.dev01.exercise02.pojos.Persona;

public class PersonaTest {
    public static void main(String[] args) {
        //HibernateUtil.tableDrop("drop table personas");
        //HibernateUtil.sqlExecute("create table personas(pers_id int, pers_paternal VARCHAR(50), pers_maternal VARCHAR(50), pers_name VARCHAR(50))");

        // Crear un SessionFactory y un objeto Session
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction tx = null; // Encapsula el cilo de vida de las operaciones en una transaccion
        try {
            tx = session.beginTransaction();

            // Crea un objeto persona y la elimina de la base de datos
            Persona p1 = new Persona();
            p1.setId(11);
            p1.setPaternal("Gallardo");
            p1.setName("Marcelo");
            session.delete(p1);

            // Actualiza datos de una persona a la base de datos
            Persona p2 = new Persona();
            p2.setId(4);
            p2.setPaternal("VASQUEZ");
            p2.setName("Axel Jozimar");
            session.update(p2);

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        HibernateUtil.dataSelect("select * from personas");
    }
}