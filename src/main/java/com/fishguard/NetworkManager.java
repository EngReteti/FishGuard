package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * NetworkManager handles the communication between Python and Java.
 * Session 12: Continuous Monitoring Loop.
 */
public class NetworkManager {
    private ServerSocket serverSocket;
    private int port;

    public NetworkManager(int port) {
        this.port = port;
    }

    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER]: FishGuard Live Monitor active on port " + port + "...");

            // The loop keeps the server running indefinitely
            while (true) {
                System.out.println("\n[SERVER]: Waiting for next reading...");
                
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                    
                    String rawData = in.readLine();
                    if (rawData != null) {
                        System.out.println("[RECEIVED]: " + rawData);
                        WaterMetrics reading = new WaterMetrics(rawData);
                        new AlertSystem().checkMetrics(reading);
                    }
                } catch (IOException e) {
                    System.out.println("[ERROR]: Individual connection failed: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Server failed: " + e.getMessage());
        }
    }
}
