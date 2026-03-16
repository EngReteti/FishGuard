package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * ClientHandler manages an individual sensor connection on a separate thread.
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
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String rawData = in.readLine();
            if (rawData != null) {
                WaterMetrics reading = new WaterMetrics(rawData);
                System.out.println("\n[THREAD " + Thread.currentThread().getId() + "]: Received " + rawData);
                
                // Alert check
                new AlertSystem().checkMetrics(reading);
                
                // Log data via manager
                manager.logData(reading);
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
