package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * ClientHandler with Basic Authentication.
 * Session 16: Security Gate added.
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private NetworkManager manager;
    private static final String SECRET_KEY = "FISH_SECURE_123";

    public ClientHandler(Socket socket, NetworkManager manager) {
        this.socket = socket;
        this.manager = manager;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            String authHeader = in.readLine(); // First line should be the key
            String rawData = in.readLine();    // Second line is the metrics

            if (SECRET_KEY.equals(authHeader) && rawData != null) {
                WaterMetrics reading = new WaterMetrics(rawData);
                System.out.println("\n[AUTH SUCCESS]: Processing data from Thread " + Thread.currentThread().getId());
                
                new AlertSystem().checkMetrics(reading);
                manager.logData(reading);
                out.println("ACK: Data Verified and Logged.");
            } else {
                System.out.println("[AUTH FAILED]: Unauthorized connection attempt blocked.");
                out.println("ERROR: Unauthorized Access.");
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Connection error: " + e.getMessage());
        } finally {
            try { socket.close(); } catch (IOException e) { }
        }
    }
}
