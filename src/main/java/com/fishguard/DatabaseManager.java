package com.fishguard;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DatabaseManager handles persistent storage for pond metrics.
 * Session 17: Initializing the DAO (Data Access Object) structure.
 */
public class DatabaseManager {
    
    // We will initialize the actual JDBC connection in Session 18
    public DatabaseManager() {
        System.out.println("[DB]: Initializing Database Controller...");
    }

    /**
     * Placeholder for saving metrics to a structured database.
     */
    public void saveToDatabase(WaterMetrics m) {
        // This will be replaced with an "INSERT INTO" SQL query soon
        System.out.println("[DB]: Preparing SQL Insert for " + m.getPhLevel() + " pH");
    }
}
