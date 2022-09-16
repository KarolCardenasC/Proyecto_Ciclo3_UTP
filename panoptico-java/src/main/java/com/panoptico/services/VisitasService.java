package com.panoptico.services;

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
}
