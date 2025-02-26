package com.gestioncitas.controllers;

import com.gestioncitas.models.Paciente;
import com.gestioncitas.services.PacienteService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteController {
    
    private final PacienteService pacienteService;
    
    public PacienteController() {
        this.pacienteService = new PacienteService();
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
    
    public Paciente obtenerPacientePorId(String id) {
        try {
            return pacienteService.getPacienteById(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener el paciente: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean guardarPaciente(Paciente paciente) {
        try {
            if (paciente.getId() == null || paciente.getId().isEmpty()) {
                // Es un nuevo paciente
                pacienteService.createPaciente(paciente);
            } else {
                // Es una actualización
                pacienteService.updatePaciente(paciente);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar el paciente: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean eliminarPaciente(String id) {
        try {
            return pacienteService.deletePaciente(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al eliminar el paciente: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}