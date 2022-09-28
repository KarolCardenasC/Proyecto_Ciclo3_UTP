package com.panoptico.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.panoptico.model.LoginAdmin;

public class LoginService {
    private SessionFactory factory;

    public LoginService() {
        factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(LoginAdmin.class)
                .buildSessionFactory();
    }

    public Session openSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public List<LoginAdmin> getLoginAdmin() {
        List<LoginAdmin> loginAdmin = new ArrayList<>();
        Session session = openSession();
        try {
            loginAdmin = session.createQuery("from LoginAdmin", LoginAdmin.class).list();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginAdmin;
    }

    public LoginAdmin getEmail(String email) {
        LoginAdmin loginAdmin = new LoginAdmin();
        Session session = openSession();
        try {
            loginAdmin = session
                    .createQuery("from LoginAdmin where email = :param_email", LoginAdmin.class)
                    .setParameter("param_email", email).uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginAdmin;
    }

    public LoginAdmin getPass(String pass) {
        LoginAdmin loginAdmin = new LoginAdmin();
        Session session = openSession();
        try {
            loginAdmin = session
                    .createQuery("from LoginAdmin where pass = :param_pass", LoginAdmin.class)
                    .setParameter("param_pass", pass).uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loginAdmin;
    }

    public boolean login(String username, String clave) {
        boolean flag= false;    
        Session session = openSession();
        try {
          List<LoginAdmin> list = session.createQuery("from LoginAdmin where email = :param_usuario and pass = :param_contrasenia", LoginAdmin.class)
            .setParameter("param_usuario", username)
            .setParameter("param_contrasenia", clave)
            .list();
            if(list.size()>0){
              System.out.println(list.get(0));
              flag = true;
          }
          session.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
        return flag;
      } 

}
