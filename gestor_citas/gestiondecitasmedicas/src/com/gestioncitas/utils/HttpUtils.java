package com.gestioncitas.utils;

import com.gestioncitas.config.Config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase de utilidad para realizar peticiones HTTP al backend
 */
public class HttpUtils {
    
    /**
     * Realiza una petición GET al endpoint especificado
     * 
     * @param endpoint URL del endpoint
     * @return String con la respuesta del servidor
     * @throws IOException si ocurre un error en la comunicación
     */
    public static String get(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Configuración de la conexión
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(Config.CONNECTION_TIMEOUT);
        connection.setReadTimeout(Config.READ_TIMEOUT);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Leer respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            throw new IOException("Error en la petición GET. Código de respuesta: " + responseCode);
        }
    }
    
    /**
     * Realiza una petición POST al endpoint especificado con los datos proporcionados
     * 
     * @param endpoint URL del endpoint
     * @param jsonData Datos en formato JSON a enviar
     * @return String con la respuesta del servidor
     * @throws IOException si ocurre un error en la comunicación
     */
    public static String post(String endpoint, String jsonData) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Configuración de la conexión
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(Config.CONNECTION_TIMEOUT);
        connection.setReadTimeout(Config.READ_TIMEOUT);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        // Enviar datos
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes("UTF-8");
            os.write(input, 0, input.length);
        }
        
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
            // Leer respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            throw new IOException("Error en la petición POST. Código de respuesta: " + responseCode);
        }
    }
    
    /**
     * Realiza una petición PUT al endpoint especificado con los datos proporcionados
     * 
     * @param endpoint URL del endpoint
     * @param jsonData Datos en formato JSON a enviar
     * @return String con la respuesta del servidor
     * @throws IOException si ocurre un error en la comunicación
     */
    public static String put(String endpoint, String jsonData) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Configuración de la conexión
        connection.setRequestMethod("PUT");
        connection.setConnectTimeout(Config.CONNECTION_TIMEOUT);
        connection.setReadTimeout(Config.READ_TIMEOUT);
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        
        // Enviar datos
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonData.getBytes("UTF-8");
            os.write(input, 0, input.length);
        }
        
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // Leer respuesta
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            
            return response.toString();
        } else {
            throw new IOException("Error en la petición PUT. Código de respuesta: " + responseCode);
        }
    }
    
    /**
     * Realiza una petición DELETE al endpoint especificado
     * 
     * @param endpoint URL del endpoint
     * @return String con la respuesta del servidor
     * @throws IOException si ocurre un error en la comunicación
     */
    public static String delete(String endpoint) throws IOException {
        URL url = new URL(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        
        // Configuración de la conexión
        connection.setRequestMethod("DELETE");
        connection.setConnectTimeout(Config.CONNECTION_TIMEOUT);
        connection.setReadTimeout(Config.READ_TIMEOUT);
        
        int responseCode = connection.getResponseCode();
        
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_NO_CONTENT) {
            // La operación DELETE fue exitosa
            return "Recurso eliminado con éxito";
        } else {
            throw new IOException("Error en la petición DELETE. Código de respuesta: " + responseCode);
        }
    }
}