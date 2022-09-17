package com.panoptico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "estudiantes_inscritos")
public class EstudiantesInscritos {
    // Atributos
    @Id
    @Column(name = "id_estudiante")
    private int idEstudiante;
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;

    public EstudiantesInscritos() {

    }

    public EstudiantesInscritos(int idEstudiante, String cedula, String nombre, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;

    }

    @Override
    public String toString() {
        String info = "---------------------\n";
        info += "cedula: " + cedula;
        info += "\nNombre: " + nombre;
        info += "\nTelefono: " + telefono;
        info += "\nEmail: " + email;
        info += "\n---------------------\n";
        return info;
    }

    // GETTERS
    public int getidEstudiante() {
        return idEstudiante;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

}
