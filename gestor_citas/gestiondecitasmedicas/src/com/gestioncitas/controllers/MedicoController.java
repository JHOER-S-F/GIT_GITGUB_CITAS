package com.gestioncitas.controllers;

import com.gestioncitas.models.Medico;
import com.gestioncitas.services.MedicoService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MedicoController {
    
    private final MedicoService medicoService;
    
    public MedicoController() {
        this.medicoService = new MedicoService();
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
    
    public Medico obtenerMedicoPorId(String id) {
        try {
            return medicoService.getMedicoById(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al obtener el médico: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public boolean guardarMedico(Medico medico) {
        try {
            if (medico.getId() == null || medico.getId().isEmpty()) {
                // Es un nuevo médico
                medicoService.createMedico(medico);
            } else {
                // Es una actualización
                medicoService.updateMedico(medico);
            }
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al guardar el médico: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    public boolean eliminarMedico(String id) {
        try {
            return medicoService.deleteMedico(id);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "Error al eliminar el médico: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}