package com.gestioncitas.services;

import com.gestioncitas.config.Config;
import com.gestioncitas.models.Cita;
import com.gestioncitas.models.Medico;
import com.gestioncitas.models.Paciente;
import com.gestioncitas.utils.HttpUtils;
import com.gestioncitas.utils.JsonUtils;
import java.io.IOException;
import java.util.List;

public class CitaService {
    
    private PacienteService pacienteService;
    private MedicoService medicoService;
    
    public CitaService() {
        this.pacienteService = new PacienteService();
        this.medicoService = new MedicoService();
    }
    
    public List<Cita> getAllCitas() throws IOException {
        String jsonResponse = HttpUtils.get(Config.CITAS_ENDPOINT);
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        List<Medico> medicos = medicoService.getAllMedicos();
        return JsonUtils.jsonToListaCitas(jsonResponse, pacientes, medicos);
    }
    
    public Cita getCitaById(String id) throws IOException {
        String jsonResponse = HttpUtils.get(Config.CITAS_ENDPOINT + "/" + id);
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        List<Medico> medicos = medicoService.getAllMedicos();
        return JsonUtils.jsonToCita(jsonResponse, pacientes, medicos);
    }
    
    public Cita createCita(Cita cita) throws IOException {
        String jsonData = JsonUtils.citaToJson(cita);
        String jsonResponse = HttpUtils.post(Config.CITAS_ENDPOINT, jsonData);
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        List<Medico> medicos = medicoService.getAllMedicos();
        return JsonUtils.jsonToCita(jsonResponse, pacientes, medicos);
    }
    
    public Cita updateCita(Cita cita) throws IOException {
        String jsonData = JsonUtils.citaToJson(cita);
        String jsonResponse = HttpUtils.put(Config.CITAS_ENDPOINT + "/" + cita.getId(), jsonData);
        List<Paciente> pacientes = pacienteService.getAllPacientes();
        List<Medico> medicos = medicoService.getAllMedicos();
        return JsonUtils.jsonToCita(jsonResponse, pacientes, medicos);
    }
    
    public boolean deleteCita(String id) throws IOException {
        try {
            HttpUtils.delete(Config.CITAS_ENDPOINT + "/" + id);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}