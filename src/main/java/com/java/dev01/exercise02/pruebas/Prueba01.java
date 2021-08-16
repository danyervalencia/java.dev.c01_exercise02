package com.java.dev01.exercise02.pruebas;

/**
 * Profesor:  Edwin Marrav�
 * www.cjavaperu.com
 * mail: emaravi@cjavaperu.com
 */

import com.java.dev01.exercise02.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.java.dev01.exercise02.pojos.Persona;

public class Prueba01 {

    public static void main(String[] args) {

        // Setea las tablas de la base de datos
        //HibernateUtil.droptable("drop table empleado");
        //HibernateUtil.setup("create table empleado ( id int, cnombre VARCHAR(20))");

        // Crea un SessionFactory y un objeto Session
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        // Encapsula el cilo de vida de las operaciones en una transaccion
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Crea un objeto persona y la elimina de la base de datos
            Persona p1 = new Persona();
            p1.setId(1);
            p1.setNombre("Oscar Valencia");
            session.delete(p1);

            // Actualiza datos de una persona a la base de datos
            Persona p2 = new Persona();
            p2.setId(2);
            p2.setNombre("Danyer Valencia");
            session.update(p2);

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Muestra las tablas
        HibernateUtil.checkData("select * from empleado");

    }

}