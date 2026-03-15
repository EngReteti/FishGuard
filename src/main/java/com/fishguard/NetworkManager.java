package com.fishguard;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * NetworkManager handles live communication and data logging.
 * Session 13: Integrated File Logging for network streams.
 */
public class NetworkManager {
    private ServerSocket serverSocket;
    private int port;
    private static final String LOG_FILE = "pond_history.txt";

    public NetworkManager(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER]: Live Monitor active on port " + port + "...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String rawData = in.readLine();
                    if (rawData != null) {
                        WaterMetrics reading = new WaterMetrics(rawData);
                        
                        // Display to terminal
                        System.out.println("\n[LIVE DATA]: " + rawData);
                        new AlertSystem().checkMetrics(reading);
                        
                        // Save to permanent log
                        logData(reading);
                    }
                } catch (IOException e) {
                    System.out.println("[ERROR]: Connection lost: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Server failed: " + e.getMessage());
        }
    }

    /**
     * Appends the network reading to the history file.
     */
    private void logData(WaterMetrics m) {
        // Create a simple timestamp
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        
        try (FileWriter fw = new FileWriter(LOG_FILE, true); // 'true' means append mode
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            
            out.printf("[%s] Temp: %.1fC | pH: %.1f | O2: %.1f mg/L%n", 
                        time, m.getTemperature(), m.getPhLevel(), m.getOxygen());
            System.out.println("[LOGGED]: Reading saved to " + LOG_FILE);
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not write to log: " + e.getMessage());
        }
    }
}
