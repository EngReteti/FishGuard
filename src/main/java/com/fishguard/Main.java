package com.fishguard;

/**
 * Main entry point for FishGuard.
 * Session 20: Dynamic Configuration and Phase 4 Setup.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: DATABASE READY (80%)  ");
        System.out.println("====================================");
        
        // Initialize the manager (which now handles its own ConfigLoader)
        NetworkManager network = new NetworkManager();
        
        // Start the server socket
        network.startServer();
        
        System.out.println("====================================");
    }
}
