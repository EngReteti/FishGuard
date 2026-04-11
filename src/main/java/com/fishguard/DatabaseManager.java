package com.fishguard;

import java.sql.*;

/**
 * DatabaseManager handles persistent storage via JDBC.
 * Session 23: Implementing Data Retrieval logic.
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
            System.out.println("[DB]: Metrics saved.");
            
            // Show history after every save to verify
            fetchHistory();
        } catch (SQLException e) {
            System.out.println("[DB ERROR]: Save failed: " + e.getMessage());
        }
    }

    public void fetchHistory() {
        String sql = "SELECT * FROM pond_logs ORDER BY id DESC LIMIT 5";
        System.out.println("\n--- RECENT POND HISTORY (from SQLite) ---");
        
        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                System.out.printf("ID: %d | Time: %s | Temp: %.1fC | pH: %.1f | O2: %.1f%n",
                    rs.getInt("id"),
                    rs.getString("timestamp"),
                    rs.getDouble("temperature"),
                    rs.getDouble("ph_level"),
                    rs.getDouble("oxygen_level"));
            }
            System.out.println("-----------------------------------------\n");
        } catch (SQLException e) {
            System.out.println("[DB ERROR]: Retrieval failed: " + e.getMessage());
        }
    }
}
