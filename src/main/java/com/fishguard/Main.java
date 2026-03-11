package com.fishguard;

/**
 * Main entry point for FishGuard.
 * Session 9 focus: Data Bridging (Preparing for Networking).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: NETWORKING BRIDGE     ");
        System.out.println("====================================");
        
        // Simulating a raw data string coming from the Python sensor
        String sensorData = "24.5,6.8,4.2";
        System.out.println("[INCOMING DATA]: " + sensorData);

        // Using the new String parser to create an object
        WaterMetrics incomingReading = new WaterMetrics(sensorData);
        AlertSystem alertUnit = new AlertSystem();

        System.out.println("Parsed -> Temp: " + incomingReading.getTemperature() + "C");
        
        // Run the alert check
        alertUnit.checkMetrics(incomingReading);

        System.out.println("====================================");
    }
}
