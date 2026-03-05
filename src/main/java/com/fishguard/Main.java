package com.fishguard;

import java.util.ArrayList;
import java.util.List;

/**
 * Main entry point for FishGuard.
 * Session 6 focus: Resilience and Exception Prevention.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: SMART POND MONITOR    ");
        System.out.println("   (Resilience Testing Active)      ");
        System.out.println("====================================");
        
        List<WaterMetrics> readingHistory = new ArrayList<>();
        AlertSystem alertUnit = new AlertSystem();

        // Adding valid data
        readingHistory.add(new WaterMetrics(25.0, 7.2, 6.5));
        
        // Simulating a system error: Adding a 'null' reading
        readingHistory.add(null); 
        
        // Adding another valid reading
        readingHistory.add(new WaterMetrics(26.0, 6.2, 5.5));

        for (int i = 0; i < readingHistory.size(); i++) {
            WaterMetrics current = readingHistory.get(i);
            System.out.println("\n--- Processing Reading #" + (i + 1) + " ---");
            
            // The AlertSystem now handles the 'null' reading without crashing
            alertUnit.checkMetrics(current);
        }

        System.out.println("\n====================================");
        System.out.println("   End of Resilience Test Report    ");
        System.out.println("====================================");
    }
}
