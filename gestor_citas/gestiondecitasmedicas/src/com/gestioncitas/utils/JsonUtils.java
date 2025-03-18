package com.gestioncitas.utils;

import com.gestioncitas.models.Cita;
import com.gestioncitas.models.Medico;
import com.gestioncitas.models.Paciente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Clase de utilidad para manejar JSON
 */
public class JsonUtils {
    
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
    /**
     * Convierte un paciente a formato JSON
     * 
     * @param paciente El paciente a convertir
     * @return String con el JSON del paciente
     */
    public static String pacienteToJson(Paciente paciente) {
        JSONObject json = new JSONObject();
        
        try {
            json.put("nombre", paciente.getNombre());
            json.put("apellido", paciente.getApellido());
            json.put("cedula", paciente.getCedula());
            json.put("telefono", paciente.getTelefono());
            json.put("email", paciente.getEmail());
            
            if (paciente.getFechaNacimiento() != null) {
                json.put("fechaNacimiento", DATE_FORMAT.format(paciente.getFechaNacimiento()));
            } else {
                json.put("fechaNacimiento", JSONObject.NULL);
            }
            
            json.put("direccion", paciente.getDireccion() != null ? paciente.getDireccion() : "");
            
        } catch (JSONException e) {
            System.err.println("Error al crear JSON de paciente: " + e.getMessage());
        }
        
        return json.toString();
    }
    
    /**
     * Convierte un médico a formato JSON
     * 
     * @param medico El médico a convertir
     * @return String con el JSON del médico
     */
    public static String medicoToJson(Medico medico) {
        JSONObject json = new JSONObject();
        
        try {
            json.put("nombre", medico.getNombre());
            json.put("apellido", medico.getApellido());
            json.put("cedula", medico.getCedula());
            json.put("especialidad", medico.getEspecialidad());
            json.put("telefono", medico.getTelefono());
            json.put("email", medico.getEmail());
        } catch (JSONException e) {
            System.err.println("Error al crear JSON de médico: " + e.getMessage());
        }
        
        return json.toString();
    }
    
    /**
     * Convierte una cita a formato JSON
     * 
     * @param cita La cita a convertir
     * @return String con el JSON de la cita
     */
    public static String citaToJson(Cita cita) {
        JSONObject json = new JSONObject();
        
        try {
            json.put("pacienteId", cita.getPaciente().getId());
            json.put("medicoId", cita.getMedico().getId());
            
            if (cita.getFecha() != null) {
                json.put("fecha", DATE_FORMAT.format(cita.getFecha()));
            } else {
                json.put("fecha", JSONObject.NULL);
            }
            
            json.put("hora", cita.getHora());
            json.put("motivo", cita.getMotivo());
            json.put("estado", cita.getEstado());
            json.put("observaciones", cita.getObservaciones() != null ? cita.getObservaciones() : "");
        } catch (JSONException e) {
            System.err.println("Error al crear JSON de cita: " + e.getMessage());
        }
        
        return json.toString();
    }

    public static Paciente jsonToPaciente(String jsonResponse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<Paciente> jsonToListaPacientes(String jsonResponse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<Medico> jsonToListaMedicos(String jsonResponse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Medico jsonToMedico(String jsonResponse) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    public static List<Cita> jsonToListaCitas(String jsonResponse, List<Paciente> pacientes, List<Medico> medicos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static Cita jsonToCita(String jsonResponse, List<Paciente> pacientes, List<Medico> medicos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }