package com.gestioncitas.models;

import java.util.Date;

/**
 * Modelo para una Cita médica
 */
public class Cita {
    private String id;
    private Paciente paciente;
    private Medico medico;
    private Date fecha;
    private String hora;
    private String motivo;
    private String estado; // "Programada", "Completada", "Cancelada"
    private String observaciones;
    
    // Constructor vacío
    public Cita() {
    }
    
    // Constructor con parámetros
    public Cita(String id, Paciente paciente, Medico medico, Date fecha, 
               String hora, String motivo, String estado, String observaciones) {
        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
        this.estado = estado;
        this.observaciones = observaciones;
    }
    
    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}