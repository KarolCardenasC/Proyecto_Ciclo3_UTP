package com.panoptico.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.panoptico.model.EstudiantesInscritos;

public class EstudiantesService {
    private SessionFactory factory;

    public EstudiantesService() {
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(EstudiantesInscritos.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<EstudiantesInscritos> getEstudiantesInscritos() {
        List<EstudiantesInscritos> estudiantesInscritos = new ArrayList<>();
        Session session = openSession();
        try {
            estudiantesInscritos = session.createQuery("from EstudiantesInscritos", EstudiantesInscritos.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiantesInscritos;
    }

    public EstudiantesInscritos getMascotaXId(String cedula) {
        EstudiantesInscritos estudiantesInscritos = new EstudiantesInscritos();
        Session session = openSession();
        try {
            estudiantesInscritos = session.find(EstudiantesInscritos.class, cedula);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiantesInscritos;
    }

}
