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

    public List<EstudiantesInscritos> getxCC(String cedula) {
        List<EstudiantesInscritos> estudiantesInscritos = new ArrayList<>();
        Session session = openSession();
        try {
            estudiantesInscritos = session
                    .createQuery("from EstudiantesInscritos where cedula = :param_cedula", EstudiantesInscritos.class)
                    .setParameter("param_cedula", cedula)
                    .list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiantesInscritos;
    }

    public String create(EstudiantesInscritos estudiantesInscritos) {
        String resp = "";
        Session session = openSession();
        try {
            session.persist(estudiantesInscritos);
            session.getTransaction().commit();
            resp = "Estudiante registrado con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = e.getMessage();
        }
        session.close();
        return resp;
    }

}
