package com.fishguard;

/**
 * DatabaseManager handles persistent storage for pond metrics.
 * Session 18: Defined SQL Insert logic.
 */
public class DatabaseManager {
    
    // The SQL query used to insert new readings
    private static final String INSERT_QUERY = 
        "INSERT INTO pond_logs (temperature, ph_level, oxygen_level, status) VALUES (?, ?, ?, ?)";

    public DatabaseManager() {
        System.out.println("[DB]: Database Controller ready for SQL operations.");
    }

    public void saveToDatabase(WaterMetrics m) {
        // We are now tracking the exact SQL command we need
        System.out.println("[DB]: Executing: " + INSERT_QUERY);
        System.out.println("[DB]: Values -> Temp: " + m.getTemperature() + ", pH: " + m.getPhLevel());
    }
}
