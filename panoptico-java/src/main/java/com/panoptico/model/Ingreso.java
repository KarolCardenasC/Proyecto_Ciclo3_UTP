package com.panoptico.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ingreso")
public class Ingreso {
    // Atributos
    @Id
    @Column(name = "id_ingreso")
    private int idIngreso;
    private Date fecha;
    private int ingreso_estudiante;
    private int ingreso_visita;

    public Ingreso(){

    }

    public Ingreso(int idIngreso, Date fecha, int ingreso_estudiante, int ingreso_visita) {
        this.idIngreso = idIngreso;
        this.fecha = fecha;
        this.ingreso_estudiante = ingreso_estudiante;
        this.ingreso_visita = ingreso_visita;
    }

    /* public Ingreso(Date fecha, int ingreso_estudiante, int ingreso_visita) {        
        this.fecha = fecha;
        this.ingreso_estudiante = ingreso_estudiante;
        this.ingreso_visita = ingreso_visita;
    } */
    

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIngreso_estudiante() {
        return ingreso_estudiante;
    }

    public void setIngreso_estudiante(int ingreso_estudiante) {
        this.ingreso_estudiante = ingreso_estudiante;
    }

    public int getIngreso_visita() {
        return ingreso_visita;
    }

    public void setIngreso_visita(int ingreso_visita) {
        this.ingreso_visita = ingreso_visita;
    }

}
