package com.fishguard;

import java.sql.*;

/**
 * DatabaseManager handles persistent storage via JDBC.
 * Session 22: Implementing PreparedStatements for data insertion.
 */
public class DatabaseManager {
    private String dbUrl = "jdbc:sqlite:fishguard.db";

    public DatabaseManager() {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            if (conn != null) {
                initializeTable(conn);
            }
        } catch (SQLException e) {
            System.out.println("[DB ERROR]: Initialization failed: " + e.getMessage());
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
        }
    }

    public void saveToDatabase(WaterMetrics m) {
        String sql = "INSERT INTO pond_logs(temperature, ph_level, oxygen_level) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(dbUrl);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, m.getTemperature());
            pstmt.setDouble(2, m.getPhLevel());
            pstmt.setDouble(3, m.getOxygen());
            
            pstmt.executeUpdate();
            System.out.println("[DB]: Metrics successfully saved to SQLite.");
            
        } catch (SQLException e) {
            System.out.println("[DB ERROR]: Could not save metrics: " + e.getMessage());
        }
    }
}
