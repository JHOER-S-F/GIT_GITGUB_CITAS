package com.gestioncitas.services;

import com.gestioncitas.config.Config;
import com.gestioncitas.models.Paciente;
import com.gestioncitas.utils.HttpUtils;
import com.gestioncitas.utils.JsonUtils;
import java.io.IOException;
import java.util.List;

public class PacienteService {
    
    public List<Paciente> getAllPacientes() throws IOException {
        String jsonResponse = HttpUtils.get(Config.PACIENTES_ENDPOINT);
        return JsonUtils.jsonToListaPacientes(jsonResponse);
    }
    
    public Paciente getPacienteById(String id) throws IOException {
        String jsonResponse = HttpUtils.get(Config.PACIENTES_ENDPOINT + "/" + id);
        return JsonUtils.jsonToPaciente(jsonResponse);
    }
    
    public Paciente createPaciente(Paciente paciente) throws IOException {
        String jsonData = JsonUtils.pacienteToJson(paciente);
        String jsonResponse = HttpUtils.post(Config.PACIENTES_ENDPOINT, jsonData);
        return JsonUtils.jsonToPaciente(jsonResponse);
    }
    
    public Paciente updatePaciente(Paciente paciente) throws IOException {
        String jsonData = JsonUtils.pacienteToJson(paciente);
        String jsonResponse = HttpUtils.put(Config.PACIENTES_ENDPOINT + "/" + paciente.getId(), jsonData);
        return JsonUtils.jsonToPaciente(jsonResponse);
    }
    
    public boolean deletePaciente(String id) throws IOException {
        try {
            HttpUtils.delete(Config.PACIENTES_ENDPOINT + "/" + id);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}