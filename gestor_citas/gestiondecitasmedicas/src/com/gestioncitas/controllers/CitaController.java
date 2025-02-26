package com.gestioncitas.controllers;

import com.gestioncitas.models.Cita;
import com.gestioncitas.models.Medico;
import com.gestioncitas.models.Paciente;
import com.gestioncitas.services.CitaService;
import com.gestioncitas.services.MedicoService;
import com.gestioncitas.services.PacienteService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CitaController {
    
    private final CitaService citaService;
    private final PacienteService pacienteService;
    private final MedicoService medicoService;
    
    public CitaController() {
        this.citaService = new CitaService();
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
    }
    
    public List<Cita> obtenerTodasCitas() {
        try {
            return citaService.getAllCitas();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener las citas: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
    
    public Cita obtenerCitaPorId(String id) {
        try {
            return citaService.getCitaById(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener la cita: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean guardarCita(Cita cita) {
        try {
            if (cita.getId() == null || cita.getId().isEmpty()) {
                // Es una nueva cita
                citaService.createCita(cita);
            } else {
                // Es una actualización
                citaService.updateCita(cita);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar la cita: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean eliminarCita(String id) {
        try {
            return citaService.deleteCita(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al eliminar la cita: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public List<Paciente> obtenerTodosPacientes() {
        try {
            return pacienteService.getAllPacientes();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener los pacientes: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
    
    public List<Medico> obtenerTodosMedicos() {
        try {
            return medicoService.getAllMedicos();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener los médicos: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return new ArrayList<>();
        }
    }
}