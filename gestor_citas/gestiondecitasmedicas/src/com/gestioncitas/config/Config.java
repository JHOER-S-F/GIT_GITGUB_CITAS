package com.gestioncitas.config;

/**
 * Configuración global de la aplicación
 */
public class Config {
    // URL base del servidor backend
    public static final String BASE_URL = "http://localhost:3000/api";
    
    // Endpoints específicos
    public static final String CITAS_ENDPOINT = BASE_URL + "/citas";
    public static final String MEDICOS_ENDPOINT = BASE_URL + "/medicos";
    public static final String PACIENTES_ENDPOINT = BASE_URL + "/pacientes";
    
    // Timeouts para las conexiones HTTP (en milisegundos)
    public static final int CONNECTION_TIMEOUT = 5000;
    public static final int READ_TIMEOUT = 5000;
}