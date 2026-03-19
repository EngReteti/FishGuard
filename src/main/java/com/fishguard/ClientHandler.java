package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * ClientHandler manages an individual sensor connection on a separate thread.
 * Session 15: Added Bidirectional Response logic.
 */
public class ClientHandler implements Runnable {
    private Socket socket;
    private NetworkManager manager;

    public ClientHandler(Socket socket, NetworkManager manager) {
        this.socket = socket;
        this.manager = manager;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            
            String rawData = in.readLine();
            if (rawData != null) {
                WaterMetrics reading = new WaterMetrics(rawData);
                System.out.println("\n[THREAD " + Thread.currentThread().getId() + "]: Processing " + rawData);
                
                // Process and Log
                new AlertSystem().checkMetrics(reading);
                manager.logData(reading);

                // Send confirmation back to the Python Sensor
                out.println("ACK: Data received and logged successfully.");
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Thread error: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                // Socket already closed
            }
        }
    }
}
