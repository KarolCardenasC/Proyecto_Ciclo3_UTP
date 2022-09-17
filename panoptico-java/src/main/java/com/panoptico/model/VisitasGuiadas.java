package com.panoptico.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitas_guiadas")
public class VisitasGuiadas {
    @Id
    @Column(name = "id_visitante")
    private int idVisitas;
    private String cedula;
    private String nombre;
    private String telefono;
    private String email;

    public VisitasGuiadas() {

    }

    public VisitasGuiadas(int idVisitas, String cedula, String nombre, String telefono, String email) {
        this.idVisitas = idVisitas;
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
    public int getidVisitas() {
        return idVisitas;
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

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
