package com.fishguard;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
            System.out.println("[SERVER]: Multi-threaded Monitor active on port " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                // Create a new handler and start it in a new thread
                ClientHandler handler = new ClientHandler(clientSocket, this);
                new Thread(handler).start();
            }
        } catch (IOException e) {
            System.out.println("[ERROR]: Server failed: " + e.getMessage());
        }
    }

    public synchronized void logData(WaterMetrics m) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        try (FileWriter fw = new FileWriter(LOG_FILE, true);
             PrintWriter out = new PrintWriter(new BufferedWriter(fw))) {
            out.printf("[%s] Temp: %.1fC | pH: %.1f | O2: %.1f mg/L%n", 
                        time, m.getTemperature(), m.getPhLevel(), m.getOxygen());
        } catch (IOException e) {
            System.out.println("[ERROR]: Logging failed: " + e.getMessage());
        }
    }
}
