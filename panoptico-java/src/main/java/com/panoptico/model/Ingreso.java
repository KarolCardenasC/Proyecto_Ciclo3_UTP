package com.panoptico.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Column(name = "ingreso_estudiante", nullable = true)
    private Integer ingreso_estudiante;
    @Column(name = "ingreso_visita", nullable = true)
    private Integer ingreso_visita;

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
        this.ingreso_visita = null;
    }

    public Ingreso(int ingreso_visita) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  -  HH:mm:ss");
        String fecha = ""+localDateTime.format(formato)+"";
        this.fecha = fecha;
        this.ingreso_visita = ingreso_visita;
        this.ingreso_estudiante = null;
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

    @Override
    public String toString() {
        return "Ingreso [fecha=" + fecha + ", idIngreso=" + idIngreso + ", ingreso_estudiante=" + ingreso_estudiante
                + ", ingreso_visita=" + ingreso_visita + "]";
    }


    

    
}