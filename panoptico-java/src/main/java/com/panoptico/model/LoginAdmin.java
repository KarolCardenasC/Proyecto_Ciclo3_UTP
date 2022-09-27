package com.panoptico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "login_admin")
public class LoginAdmin {
    @Id
    @Column(name = "id_admin")
    private int id;
    private String email;
    private String pass;

    public LoginAdmin() {

    }

    public LoginAdmin(int id, String email, String pass) {
        this.id = id;
        this.email = email;
        this.pass = pass;
    }

    @Override
    public String toString() {
        String info = "---------------------\n";
        info += "\nEmail: " + email;
        info += "\nPassword: " + pass;
        info += "\n---------------------\n";
        return info;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

}
