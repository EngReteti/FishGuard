package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * ClientHandler with Dynamic Authentication.
 * Session 20: Pulling Security Keys from ConfigLoader.
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private NetworkManager manager;
    private ConfigLoader config;

    public ClientHandler(Socket socket, NetworkManager manager, ConfigLoader config) {
        this.socket = socket;
        this.manager = manager;
        this.config = config;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            String authHeader = in.readLine(); 
            String rawData = in.readLine();    
            
            // Dynamically check the key from config.properties
            String expectedKey = config.getProperty("auth.key");

            if (expectedKey != null && expectedKey.equals(authHeader) && rawData != null) {
                WaterMetrics reading = new WaterMetrics(rawData);
                System.out.println("\n[AUTH SUCCESS]: Processing data stream...");
                
                new AlertSystem().checkMetrics(reading);
                manager.logData(reading);
                out.println("ACK: Data Verified and Logged.");
            } else {
                System.out.println("[AUTH FAILED]: Invalid key or malformed data.");
                out.println("ERROR: Unauthorized Access.");
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Thread error: " + e.getMessage());
        } finally {
            try { socket.close(); } catch (IOException e) { }
        }
    }
}
