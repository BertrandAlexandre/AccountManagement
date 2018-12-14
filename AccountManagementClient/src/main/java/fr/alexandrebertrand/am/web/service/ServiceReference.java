package fr.alexandrebertrand.am.web.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Resources service
 * Manage any resource from a RESTfull API
 */
public final class ServiceReference {
    
    /*
     * Attribute
     */
    
    /** HTTP connector */
    private static HttpURLConnection connector;
    
    /*
     * Constructor
     */
    
    /**
     * Empty private constructor
     */
    private ServiceReference() {
    }
    
    /*
     * Methods
     */
    
    /**
     * Get list of resources
     * 
     * @param  strUrl String URL of the service
     * @return List of resources
     * @throws IOException
     */
    public static String list(String strUrl) throws IOException {
        String input = "";
        initConnection(strUrl, "GET", false);
        getResponse(HttpURLConnection.HTTP_OK);
        input = getInput();
        connector.disconnect();
        return input;
    }
    
    /**
     * Get data from a resource
     * 
     * @param strUrl String URL of the service
     * @param id     Identifier of the resource
     * @return Searched resource
     * @throws IOException
     */
    public static String get(String strUrl, Long id) throws IOException {
        String input = "";
        initConnection(strUrl + "/" + id, "GET", false);
        getResponse(HttpURLConnection.HTTP_OK);
        input = getInput();
        connector.disconnect();
        return input;
    }
    
    /**
     * Create a new resource
     * 
     * @param strUrl String URL of the service
     * @param output String data from a resource
     * @throws IOException
     */
    public static void create(String strUrl, String output) throws IOException {
        initConnection(strUrl, "POST", true);
        setOutput(output);
        getResponse(HttpURLConnection.HTTP_CREATED);
        connector.disconnect();
    }
    
    /**
     * Update a resource
     * 
     * @param strUrl String URL of the service
     * @param id     Identifier of the resource
     * @param output String data from a resource
     * @throws IOException
     */
    public static void update(String strUrl, Long id, String output) throws IOException {
        initConnection(strUrl + "/" + id, "PUT", true);
        setOutput(output);
        getResponse(HttpURLConnection.HTTP_NO_CONTENT);
        connector.disconnect();
    }
    
    /**
     * Initialize connection to a service
     * 
     * @param strUrl    String URL of the service
     * @param method    REST method
     * @param hasOutput Indicate if an output is present
     * @throws IOException
     */
    private static void initConnection(String strUrl, String method,
                                       boolean hasOutput) throws IOException {
        URL url = new URL(strUrl);
        connector = (HttpURLConnection) url.openConnection();
        connector.setRequestMethod(method);
        if (hasOutput) {
            connector.setDoOutput(hasOutput);
            connector.setRequestProperty("Content-Type", "application/json");
        }
        connector.setRequestProperty("Accept", "application/json");
    }
    
    /**
     * Send data to the service
     * 
     * @param output Data to send
     * @throws IOException
     */
    private static void setOutput(String output) throws IOException {
        OutputStream os = connector.getOutputStream();
        os.write(output.getBytes());
        os.flush();
    }
    
    /**
     * Get data from the service
     * 
     * @return Data from the service
     * @throws IOException
     */
    private static String getInput() throws IOException {
        String input = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(
            (connector.getInputStream())));
        String line;
        while ((line = br.readLine()) != null) {
            input += line;
        }
        return input;
    }
    
    /**
     * Get HTTP response after the request
     * 
     * @param expectedHttpResponse Expected HTTP response
     * @throws IOException
     */
    private static void getResponse(int expectedHttpResponse) throws IOException {
        if (connector.getResponseCode() != expectedHttpResponse) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + connector.getResponseCode());
        }
    }

}
