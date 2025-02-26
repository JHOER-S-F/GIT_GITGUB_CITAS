package com.gestioncitas.services;

import com.gestioncitas.config.Config;
import com.gestioncitas.models.Medico;
import com.gestioncitas.utils.HttpUtils;
import com.gestioncitas.utils.JsonUtils;
import java.io.IOException;
import java.util.List;

public class MedicoService {
    
    public List<Medico> getAllMedicos() throws IOException {
        String jsonResponse = HttpUtils.get(Config.MEDICOS_ENDPOINT);
        return JsonUtils.jsonToListaMedicos(jsonResponse);
    }
    
    public Medico getMedicoById(String id) throws IOException {
        String jsonResponse = HttpUtils.get(Config.MEDICOS_ENDPOINT + "/" + id);
        return JsonUtils.jsonToMedico(jsonResponse);
    }
    
    public Medico createMedico(Medico medico) throws IOException {
        String jsonData = JsonUtils.medicoToJson(medico);
        String jsonResponse = HttpUtils.post(Config.MEDICOS_ENDPOINT, jsonData);
        return JsonUtils.jsonToMedico(jsonResponse);
    }
    
    public Medico updateMedico(Medico medico) throws IOException {
        String jsonData = JsonUtils.medicoToJson(medico);
        String jsonResponse = HttpUtils.put(Config.MEDICOS_ENDPOINT + "/" + medico.getId(), jsonData);
        return JsonUtils.jsonToMedico(jsonResponse);
    }
    
    public boolean deleteMedico(String id) throws IOException {
        try {
            HttpUtils.delete(Config.MEDICOS_ENDPOINT + "/" + id);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}