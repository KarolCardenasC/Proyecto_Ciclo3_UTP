package com.panoptico.model;

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
    private String fecha;
    private int ingreso_estudiante;
    private int ingreso_visita;

    // Constructores
    public Ingreso() {
    }

    public Ingreso(String fecha, int ingreso_estudiante, int ingreso_visita) {
        this.fecha = fecha;
        this.ingreso_estudiante = ingreso_estudiante;
        this.ingreso_visita = ingreso_visita;
    }

    public Ingreso(String fecha, int ingreso_estudiante) {
        this.fecha = fecha;
        this.ingreso_estudiante = ingreso_estudiante;
    }
    
    // Getters

    public int getIdIngreso() {
        return idIngreso;
    }

    public String getFecha() {
        return fecha;
    }

    public int getIngreso_estudiante() {
        return ingreso_estudiante;
    }

    public int getIngreso_visita() {
        return ingreso_visita;
    }

    // Setters
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setIngreso_estudiante(int ingreso_estudiante) {
        this.ingreso_estudiante = ingreso_estudiante;
    }

    public void setIngreso_visita(int ingreso_visita) {
        this.ingreso_visita = ingreso_visita;
    }

    
}