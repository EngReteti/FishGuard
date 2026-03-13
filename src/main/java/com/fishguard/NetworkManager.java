package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * NetworkManager handles the communication between the Python sensor and Java.
 * Session 11: Accepting incoming connections.
 */
public class NetworkManager {
    private ServerSocket serverSocket;
    private int port;

    public NetworkManager(int port) {
        this.port = port;
    }

    /**
     * Starts the server and waits for a connection.
     */
    public void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER]: FishGuard is online on port " + port + "...");
            System.out.println("[SERVER]: Waiting for sensor to connect...");

            // This line tells Java to wait for a "Client" (our Python script)
            Socket clientSocket = serverSocket.accept();
            System.out.println("[SERVER]: Sensor connected from: " + clientSocket.getInetAddress());

            // Prepare to read data from the connection
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String rawData = in.readLine();
            
            if (rawData != null) {
                System.out.println("[RECEIVED]: Raw data stream -> " + rawData);
                // Process the data using our existing parser
                WaterMetrics reading = new WaterMetrics(rawData);
                new AlertSystem().checkMetrics(reading);
            }

            clientSocket.close();
        } catch (IOException e) {
            System.out.println("[ERROR]: Network failure: " + e.getMessage());
        }
    }
}
