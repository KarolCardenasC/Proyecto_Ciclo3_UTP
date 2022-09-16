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
    private boolean ingreso;

    public EstudiantesInscritos() {

    }

    public EstudiantesInscritos(String idEstudiante, String nombre, String apellido, String telefono, boolean ingreso) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.ingreso = ingreso;
    }

    @Override
    public String toString() {
        String info = "---------------------\n";
        info += "idEstudiante: " + idEstudiante;
        info += "\nNombre: " + nombre;
        info += "\nApellido: " + apellido;
        info += "\nTelefono: " + telefono;
        info += "\nIngreso: " + ingreso;
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

    public boolean getIngreso() {
        return ingreso;
    }

    // SETTERS
    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }

}
