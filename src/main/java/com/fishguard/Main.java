package com.fishguard;

/**
 * Main entry point for FishGuard.
 * Session 10 focus: Initializing the Network Server for Phase 3.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: NETWORK INITIALIZED   ");
        System.out.println("====================================");
        
        // We use Port 5000 for our local communication
        NetworkManager network = new NetworkManager(5000);
        
        // Start the server socket
        network.startServer();
        
        System.out.println("====================================");
        System.out.println("   Status: Waiting for Session 11   ");
        System.out.println("====================================");
    }
}
