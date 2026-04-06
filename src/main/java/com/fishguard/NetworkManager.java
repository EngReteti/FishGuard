package com.fishguard;

import java.io.*;
import java.net.*;

public class NetworkManager {
    private ServerSocket serverSocket;
    private ConfigLoader config;
    private DatabaseManager dbManager;

    public NetworkManager() {
        this.config = new ConfigLoader();
        this.dbManager = new DatabaseManager();
    }

    public void startServer() {
        int port = Integer.parseInt(config.getProperty("server.port"));
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("[SERVER]: FishGuard Phase 4 active on port " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Pass the config to the handler for Auth verification
                ClientHandler handler = new ClientHandler(clientSocket, this, config);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Server failed: " + e.getMessage());
        }
    }

    public synchronized void logData(WaterMetrics m) {
        dbManager.saveToDatabase(m);
        // Additional logging logic remains here as backup
    }
}
