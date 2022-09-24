package com.panoptico.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public Ingreso getxId_Ingreso(int idIngreso) {
        Ingreso ingreso = new Ingreso();
        Session session = openSession();
        try {
            ingreso = session.find(Ingreso.class, idIngreso);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();

        return ingreso;
    }

    public String create_ingreso_visita(String ingreso_visita) {
        String resp = "";
        Session session = openSession();
        Ingreso ingreso = new Ingreso(ingreso_visita);

        try {
            session.persist(ingreso);
            session.getTransaction().commit();
            resp = "Estudiante No inscrito ingresado a la tabla registro con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = "ERROR !!! No se pudo registrar el Estudiante No inscrito en la tabla ingreso" + e.getMessage();
        }
        session.close();
        return resp;
    }

    public String create_ingreso_estudiante(String ingreso_estudiante) {
        String resp = "";
        Session session = openSession();
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  -  HH:mm:ss");
        String fecha = ""+localDateTime.format(formato)+"";
        Ingreso ingreso = new Ingreso(fecha, ingreso_estudiante);
        try {
            session.persist(ingreso);
            session.getTransaction().commit();
            resp = "Estudiante Inscrito ingresado a la tabla registro con éxito";
        } catch (Exception e) {
            e.printStackTrace();
            resp = "ERROR !!! No se pudo registrar el estudiante Inscrito en la tabla ingreso" + e.getMessage();
        }
        session.close();
        return resp;
    }

    public String deleteIngresoxId(int idIngreso){
        String message = "";
        Session session = openSession();

        try {
            Ingreso ingreso = getxId_Ingreso(idIngreso);
            session.remove(ingreso);
            session.getTransaction().commit();
            message = "Ingreso eliminado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

}
