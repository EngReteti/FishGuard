package com.fishguard;

import java.io.*;
import java.net.*;

/**
 * NetworkManager handles the communication between the Python sensor and Java.
 * Session 10: Initializing the Server Socket.
 */
public class NetworkManager {
    private ServerSocket serverSocket;
    private int port;

    public NetworkManager(int port) {
        this.port = port;
    }

    /**
     * Starts the server to listen for incoming sensor data.
     */
    public void startServer() {
        try {
            // Opening the ServerSocket on the specified port
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER]: FishGuard is online and listening on port " + port + "...");
            
            // Note: In Session 11, we will add the 'accept' logic here 
            // to actually receive the data strings.
            
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not start network server: " + e.getMessage());
        }
    }
}
