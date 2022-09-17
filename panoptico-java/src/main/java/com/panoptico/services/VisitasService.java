package com.panoptico.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.panoptico.model.VisitasGuiadas;

public class VisitasService {
    private SessionFactory factory;

    public VisitasService() {
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(VisitasGuiadas.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<VisitasGuiadas> getVisitasGuiadas() {
        List<VisitasGuiadas> visitasGuiadas = new ArrayList<>();
        Session session = openSession();
        try {
            visitasGuiadas = session.createQuery("from VisitasGuiadas", VisitasGuiadas.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visitasGuiadas;
    }

    public String create(VisitasGuiadas visitasGuiadas) {
        String resp = "";
        Session session = openSession();
        try {
            session.persist(visitasGuiadas);
            session.getTransaction().commit();
            resp = "Visitante registrado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        session.close();
        return resp;
    }

}
