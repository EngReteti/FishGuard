package com.fishguard;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Main entry point for FishGuard.
 * Session 7 focus: File Persistence (Saving data to storage).
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   FISHGUARD: SMART POND MONITOR    ");
        System.out.println("   (Data Persistence Mode Active)   ");
        System.out.println("====================================");
        
        List<WaterMetrics> readingHistory = new ArrayList<>();
        
        // Simulating data collection
        readingHistory.add(new WaterMetrics(25.0, 7.2, 6.5));
        readingHistory.add(new WaterMetrics(28.5, 7.0, 4.8));
        readingHistory.add(new WaterMetrics(26.0, 6.2, 5.5));

        // Step 1: Save the data to a file
        saveHistoryToFile(readingHistory);

        System.out.println("\n====================================");
        System.out.println("   Session 7: Data Saved Locally    ");
        System.out.println("====================================");
    }

    /**
     * Writes the collection of pond readings to a text file.
     * Uses try-with-resources to ensure the file closes properly.
     */
    private static void saveHistoryToFile(List<WaterMetrics> history) {
        String fileName = "pond_history.txt";
        
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("--- FishGuard Pond History ---\n");
            for (WaterMetrics m : history) {
                String record = String.format("Temp: %.1fC | pH: %.1f | O2: %.1f mg/L\n", 
                                m.getTemperature(), m.getPhLevel(), m.getOxygen());
                writer.write(record);
            }
            System.out.println("[SUCCESS]: History saved to " + fileName);
        } catch (IOException e) {
            System.out.println("[ERROR]: Could not save file: " + e.getMessage());
        }
    }
}
