package com.panoptico.model;

import java.util.Date;

public class VisitasGuiadas {
    private int idVisitas;
    private String cedula;
    private String nombre;
    private String apellido;
    private Date fecha;

    public VisitasGuiadas() {

    }

    public VisitasGuiadas(String cedula, String nombre, String apellido, Date fecha) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha = fecha;
    }

    public int getIdVisitas() {
        return idVisitas;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
