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

    public EstudiantesInscritos getxCC(String cedula) {
        EstudiantesInscritos estudiantesInscritos = new EstudiantesInscritos();
        Session session = openSession();
        try {
            estudiantesInscritos = session
                    .createQuery("from EstudiantesInscritos where cedula = :param_cedula", EstudiantesInscritos.class)
                    .setParameter("param_cedula", cedula).uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estudiantesInscritos;
    }

    public boolean existe(String cedula) {
        EstudiantesInscritos estudiantesInscritos = new EstudiantesInscritos();
        boolean existe = false;
        Session session = openSession();
        try {
            estudiantesInscritos = session
                    .createQuery("from EstudiantesInscritos where cedula = :param_cedula", EstudiantesInscritos.class)
                    .setParameter("param_cedula", cedula).uniqueResult();
            if(estudiantesInscritos.getCedula().isEmpty() == false){
                        existe=true;
            }
            session.close();           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existe;
    }

    public EstudiantesInscritos getxId(int idEstudiante) {
        EstudiantesInscritos estudiantesInscritos = new EstudiantesInscritos();
        Session session = openSession();
        try {
            estudiantesInscritos = session.find(EstudiantesInscritos.class, idEstudiante);
        } catch (Exception e) {
            e.printStackTrace();
        }

        session.close();

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

    public String create_register_estudiante(EstudiantesInscritos estudiantesInscritos) {

        IngresoService ingreso = new IngresoService();

        String crear = create(estudiantesInscritos);

        String cedula = estudiantesInscritos.getCedula();
        String registrar = ingreso.create_ingreso_estudiante(cedula);

        return crear + "\n" + registrar;
    }

    public String updateEstudiantesInscritos(EstudiantesInscritos estudiantesInscritos) {
        String message = "";
        Session session = openSession();

        try {
            session.merge(estudiantesInscritos);
            session.getTransaction().commit();
            message = "Estudiante Inscrito actualizado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

    public String deleteEstudiantesInscritosxId(int idEstudiante) {
        String message = "";
        Session session = openSession();

        try {
            EstudiantesInscritos estudiantesInscritos = getxId(idEstudiante);
            session.remove(estudiantesInscritos);
            session.getTransaction().commit();
            message = "Estudiante Inscrito eliminado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

    public String deleteEstudiantesInscritosxCC(String cedula){
        String message = "";
        Session session = openSession();

        try {
            EstudiantesInscritos estudiantesInscritos = getxCC(cedula);
            session.remove(estudiantesInscritos);
            session.getTransaction().commit();
            message = "Estudiante Inscrito eliminado con éxito!";
        } catch (Exception e) {
            message = e.getMessage();
        }

        session.close();

        return message;
    }

}
