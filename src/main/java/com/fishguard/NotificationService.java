package com.fishguard;

/**
 * NotificationService: Production-grade alerting.
 * Session 25: Initializing the Emergency SMS logic.
 */
public class NotificationService {
    
    public void sendEmergencyAlert(String message) {
        // In a real-world scenario, this triggers an SMS/WhatsApp API call.
        System.out.println("\n[NOTIFICATION]: 🚨 DISPATCHING EMERGENCY SMS...");
        System.out.println("[SMS CONTENT]: " + message);
        System.out.println("[STATUS]: Alert sent to registered Farmer mobile number.\n");
    }
}
