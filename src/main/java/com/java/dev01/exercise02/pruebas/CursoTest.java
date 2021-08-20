package com.java.dev01.exercise02.pruebas;

import com.java.dev01.exercise02.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.java.dev01.exercise02.pojos.Curso;

public class CursoTest {
    public static void main(String[] args) {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        Transaction tx = null; // Encapsula el ciclo de vida de las operaciones en una transaccion
        try {
            tx = session.beginTransaction();

            Curso c1 = new Curso();
            c1.setCursCode("C11");
            c1.setCursName(".Net Core Junior");
            c1.setCursCredits(3);
            session.save(c1);

            Curso c2 = new Curso();
            c2.setCursCode("C12");
            c2.setCursName(".Net Core Developer");
            c2.setCursCredits(4);
            session.save(c2);

            // Obtiene objetos de la base de datos
            Curso curso = (Curso) session.get(Curso.class, c1.getCursCode());
            System.out.println("Primer curso agregado = " + curso.getCursName());

            curso = (Curso) session.get(Curso.class, c2.getCursCode());
            System.out.println("Segundo curso agregado = " + curso.getCursName());

            System.out.println("lombok ToString => " + curso);

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if ( tx != null ) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        // Muestra registros de tabla
        HibernateUtil.dataSelect("select * from cursos");
    }
}