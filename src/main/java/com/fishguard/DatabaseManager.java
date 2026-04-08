package com.fishguard;

import java.sql.*;

/**
 * DatabaseManager handles persistent storage via JDBC.
 * Session 21: Integrating the SQLite Connection Bridge.
 */
public class DatabaseManager {
    private String dbUrl = "jdbc:sqlite:fishguard.db";

    public DatabaseManager() {
        try {
            // Test the connection and create the table if missing
            try (Connection conn = DriverManager.getConnection(dbUrl)) {
                if (conn != null) {
                    System.out.println("[DB]: Connected to SQLite database.");
                    initializeTable(conn);
                }
            }
        } catch (SQLException e) {
            System.out.println("[DB ERROR]: Connection failed: " + e.getMessage());
        }
    }

    private void initializeTable(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pond_logs ("
                   + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                   + "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP,"
                   + "temperature REAL,"
                   + "ph_level REAL,"
                   + "oxygen_level REAL"
                   + ");";
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("[DB]: Table 'pond_logs' is ready.");
        }
    }

    public void saveToDatabase(WaterMetrics m) {
        // Placeholder for the actual INSERT statement in the next bit
        System.out.println("[DB]: Ready to insert reading into SQLite.");
    }
}
