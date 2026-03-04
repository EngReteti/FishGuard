package com.fishguard;

import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for FishGuard.
 * Session 5 focus: Implementing Data Collections (Lists).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: SMART POND MONITOR    ");
        System.out.println("   (History Tracking Mode Active)   ");
        System.out.println("====================================");
        
        // Initialize our data collection (List of readings)
        List<WaterMetrics> readingHistory = new ArrayList<>();
        AlertSystem alertUnit = new AlertSystem();

        // Simulating multiple readings throughout the day
        readingHistory.add(new WaterMetrics(25.0, 7.2, 6.5)); // Morning: SAFE
        readingHistory.add(new WaterMetrics(28.5, 7.0, 4.8)); // Afternoon: LOW OXYGEN
        readingHistory.add(new WaterMetrics(26.0, 6.2, 5.5)); // Evening: pH UNSTABLE

        // Iterate through the history and process each reading
        for (int i = 0; i < readingHistory.size(); i++) {
            WaterMetrics current = readingHistory.get(i);
            System.out.println("\n--- Processing Reading #" + (i + 1) + " ---");
            System.out.println("Stats -> Temp: " + current.getTemperature() + "C | pH: " + current.getPhLevel() + " | O2: " + current.getOxygen());
            
            // Check each historical reading for alerts
            alertUnit.checkMetrics(current);
        }

        System.out.println("\n====================================");
        System.out.println("   End of Historical Data Report    ");
        System.out.println("====================================");
    }
}
