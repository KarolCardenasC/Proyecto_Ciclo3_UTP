package com.panoptico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "#")
public class EstudiantesInscritos {
    // Atributos
    @Id
    @Column(name = "#")
    private String idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public EstudiantesInscritos() {

    }

    public EstudiantesInscritos(String idEstudiante, String nombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        String info = "---------------------\n";
        info += "idEstudiante: " + idEstudiante;
        info += "\nNombre: " + nombre;
        info += "\nApellido: " + apellido;
        info += "\nTelefono: " + telefono;
        info += "\nEmail: " + email;
        info += "\n---------------------\n";
        return info;
    }

    // GETTERS
    public String getidEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    // SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
