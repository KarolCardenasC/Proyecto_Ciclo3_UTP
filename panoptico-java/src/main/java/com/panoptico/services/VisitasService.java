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

    public VisitasGuiadas getxCC_VisitasGuiadas(String cedula) {
        VisitasGuiadas visitasGuiadas = new VisitasGuiadas();
        Session session = openSession();
        try {
            visitasGuiadas = session
                    .createQuery("from VisitasGuiadas where cedula = :param_cedula", VisitasGuiadas.class)
                    .setParameter("param_cedula", cedula).uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visitasGuiadas;
    }

    public VisitasGuiadas getxId_VisitasGuiadas(int idVisitas) {
        VisitasGuiadas visitasGuiadas = new VisitasGuiadas();
        Session session = openSession();
        try {
            visitasGuiadas = session.find(VisitasGuiadas.class, idVisitas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();

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

    public String create_register_visita(VisitasGuiadas visitasGuiadas) {

        IngresoService ingreso = new IngresoService();

        String crear = create(visitasGuiadas);

        String cedula = visitasGuiadas.getCedula();
        String registrar = ingreso.create_ingreso_visita(cedula);

        return crear + "\n" + registrar;
    }

    public String updateVisitasGuiadas(VisitasGuiadas visitasGuiadas){
        String message = "";
        Session session = openSession();

        try {
            session.merge(visitasGuiadas);
            session.getTransaction().commit();
            message = "Estudiante No Inscrito actualizado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

    public String deleteVisitasGuiadasxId(int idVisitas){
        String message = "";
        Session session = openSession();

        try {
            VisitasGuiadas visitasGuiadas = getxId_VisitasGuiadas(idVisitas);
            session.remove(visitasGuiadas);
            session.getTransaction().commit();
            message = "Estudiante No Inscrito eliminado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

    public String deleteVisitasGuiadasxCC(String cedula){
        String message = "";
        Session session = openSession();

        try {
            VisitasGuiadas visitasGuiadas = getxCC_VisitasGuiadas(cedula);
            session.remove(visitasGuiadas);
            session.getTransaction().commit();
            message = "Estudiante No Inscrito eliminado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }
}
