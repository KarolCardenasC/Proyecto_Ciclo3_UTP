package com.panoptico.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.panoptico.model.Ingreso;

public class IngresoService {
    private SessionFactory factory;

    public IngresoService() {
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Ingreso.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<Ingreso> getIngreso() {
        List<Ingreso> ingreso = new ArrayList<>();
        Session session = openSession();
        try {
            ingreso = session.createQuery("from Ingreso", Ingreso.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingreso;
    }

    public String create_ingreso(int ingreso_estudiante, int ingreso_visita) {
        String resp = "";
        Session session = openSession();
        LocalDateTime localDateTime = LocalDateTime.now();
        String fecha = ""+localDateTime+"";
        Ingreso ingreso = new Ingreso(fecha, ingreso_estudiante, ingreso_visita);
        try {
            session.persist(ingreso);
            session.getTransaction().commit();
            resp = "Estudiante ingresado a la tabla registro con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = "ERROR !!! No se pudo registrar en la tabla ingreso" + e.getMessage();
        }
        session.close();
        return resp;
    }

    public String create_ingreso_estudiante(int ingreso_estudiante) {
        String resp = "";
        Session session = openSession();
        LocalDateTime localDateTime = LocalDateTime.now();
        String fecha = ""+localDateTime+"";
        Ingreso ingreso = new Ingreso(fecha, ingreso_estudiante);
        try {
            session.persist(ingreso);
            session.getTransaction().commit();
            resp = "Estudiante ingresado a la tabla registro con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = "ERROR !!! No se pudo registrar en la tabla ingresp" + e.getMessage();
        }
        session.close();
        return resp;
    }

}
