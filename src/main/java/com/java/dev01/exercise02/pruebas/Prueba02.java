package com.java.dev01.exercise02.pruebas;

import com.java.dev01.exercise02.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.dev01.exercise02.pojos.Curso;

public class Prueba02 {
    public static void main(String[] args) {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        //1. insertar un nuevo curso
        //2. listar los cursos

        Transaction tx = null; // Encapsula el cilo de vida de las operaciones en una transaccion
        try {
            tx = session.beginTransaction();

            Curso c1 = new Curso();
            c1.setCodigo("c04");
            c1.setNombre("Java Basic");
            c1.setCreditos(3);
            session.save(c1);

            Curso c2 = new Curso();
            c2.setCodigo("c05");
            c2.setNombre("Java Intermedio");
            c2.setCreditos(4);
            session.save(c2);

            // Obtiene objetos de la base de datos
            Curso curso = (Curso) session.get(Curso.class, c1.getCodigo());
            System.out.println("Primer curso agregado = " + curso.getNombre());

            curso = (Curso) session.get(Curso.class, c2.getCodigo());
            System.out.println("Segundo curso agregado = " + curso.getNombre());

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Muestra las tablas
        HibernateUtil.checkData("select * from curso");
    }
}
